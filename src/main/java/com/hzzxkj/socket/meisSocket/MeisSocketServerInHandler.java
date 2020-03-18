package com.hzzxkj.socket.meisSocket;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sound.midi.SysexMessage;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hzzxkj.BootApplication;
import com.hzzxkj.SpringBeanUtil;
import com.hzzxkj.Logger.HzzxLogger;
import com.hzzxkj.cmdAnaliser.CMDID;
import com.hzzxkj.cmdAnaliser.CRC16Util;
import com.hzzxkj.cmdAnaliser.CmdFactory;
import com.hzzxkj.cmdAnaliser.CmdModel;
import com.hzzxkj.cmdAnaliser.CmdUtils;
import com.hzzxkj.controller.ControllerEorrConstant;
import com.hzzxkj.dao.ClientInfoMapper;
import com.hzzxkj.models.ClientInfo;
import com.hzzxkj.mongodb.dao.ClientOnLineDao;
import com.hzzxkj.mongodb.entity.ClientOnLine;
import com.hzzxkj.socket.meisSetSocket.MeisSetChannelMap;
import com.hzzxkj.socket.meisSetSocket.MeisSetSocketServerInHandler;
import com.hzzxkj.utils.DateUtils;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 对通道接收到的数据进行处理
 * 
 * @author guoxinan
 * @date 2018年10月9日
 * @parameter channel对应的handler
 * @return
 */
public class MeisSocketServerInHandler extends ChannelHandlerAdapter {

	/**
	 * 设备状态实体
	 */
	public ClientInfo cInfo;
	/**
	 * 设备状态表操作类
	 */
	public ClientInfoMapper cinfoMapper;

	// 是否收到采集器的反馈指令
	public boolean isreceiveback = false;

	public ChannelHandlerContext mctx;

	/**
	 * 该通道发送的未收到反馈的指令集合
	 */
	public ArrayList<CMDID> CmdidList;
	/**
	 * 同步锁 用于锁住cmdidlist
	 */
	public Object listLock = new Object();
	private boolean isSaveOnline = false;
	private String mHospitalId;
	private String mDeviceID;
	private String mWifiMac;
	/**
	 * 用于保存每台设备连接时的key
	 */
	String strKey = "NettyLog";

	/**
	 * 数据库操作类工厂
	 */
	public SqlSessionFactory o = (SqlSessionFactory) SpringBeanUtil.getBean("sqlSessionFactory");

	private ClientOnLineDao clientOnLineDao = BootApplication.applicationContext.getBean(ClientOnLineDao.class);

	@Override
	/**
	 * 在channel被启用的时候触发 (在建立连接的时候)
	 */
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		mctx = ctx;
		CmdidList = new ArrayList<CMDID>();
		HzzxLogger.info("MeisSocketServerInHandler:channelActive" + "客户端IP：" + ctx.channel().remoteAddress()
				+ "连接成功，当前MeisChannelMap连接数量：" + String.valueOf(MeisChannelMap.getSize() + 1), "NettyLog");
	}

	@Override
	/**
	 * channel失效处理,客户端下线或者强制退出等任何情况都触发这个方法
	 */
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// 通过Channel找到对应Channel的key，通过Channel的key找到采集器协议版本，找到则移除
		String cmdKey = MeisChannelMap.getMapKey(ctx.channel());
		if (cmdKey == null) {
			HzzxLogger.info("MeisSocketServerInHandler:channelInactive" + "客户端：" + ctx.channel().remoteAddress()
					+ "断开连接，连接未通讯，所以MeisChaneelMap实际没有增加，当前MeisChannelMap中数量："
					+ String.valueOf(MeisChannelMap.getSize()), "NettyLog");
		} else {
			HzzxLogger.info("MeisSocketServerInHandler:channelInactive" + "客户端：" + cmdKey + "断开连接，当前MeisChannelMap连接数量："
					+ String.valueOf(MeisChannelMap.getSize() - 1), "NettyLog");
		}
		if (cmdKey != null) {
			// 从cmdmap移除
			if (MeisCmdVersionMap.get(cmdKey) != -1) {
				MeisCmdVersionMap.remove(cmdKey);
			}
			// 更新mongodb数据库中clientonline表 保存设备的在线不在线
			if (isSaveOnline) {
				ClientOnLine clientOnLine = new ClientOnLine();
				clientOnLine.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				clientOnLine.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				clientOnLine.setHospitalId(mHospitalId);
				clientOnLine.setDeviceId(mDeviceID);
				clientOnLine.setWifiMac(mWifiMac);
				clientOnLine.setValue("0");
				clientOnLine.setTickNum(0);
				clientOnLine.setEventTime(new Date());
				clientOnLine.setEventID("Equipment_Online_ByBoard");
				clientOnLineDao.insertDemo(clientOnLine);
				isSaveOnline = false;
			}
			// 更新sqlserver
			cInfo = new ClientInfo();
			cInfo.setIsOnline("0");
			cInfo.setLastOnline(new Date());
			cInfo.setHospitalId(String.valueOf(mHospitalId));
			cInfo.setDeviceId(String.valueOf(mDeviceID));
			try {
				SqlSession session = o.openSession(true);
				cinfoMapper = session.getMapper(ClientInfoMapper.class);

				int i = cinfoMapper.updateByhospitalanddevice(cInfo);

				if (i > 0) {
					HzzxLogger.debug("更新cleint_info表成功", strKey);
				} else {
					HzzxLogger.debug("更新cleint_info表失败", strKey);
				}
				session.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				HzzxLogger.error("操作数据库失败：", e, strKey);
			}
		}
		// 从channelmap移除
		MeisChannelMap.remove(ctx.channel());
	}

	@Override
	/**
	 * 读取channel的pipeline列表中由上一个handle处理完后out出来的数据,
	 * 对接收到的数据进行crc校验及反馈，并将当前设备的唯一号和协议版本添加到cmdversionmap中
	 */
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		byte[] reqtemp = (byte[]) msg;
		try {
			
			
			// 接受数据时 要去除字节中的转义符后再进行校验
			String original = CmdUtils.ByteArrayToHexString(reqtemp).replaceAll("55 ff", "55").replaceAll("33 ff",
					"33");
			byte[] req = CmdUtils.HexStringToByteArray(original, " ");
			//
            
			CmdModel cmdModel = CmdFactory.CreateCmd(req);

			// 转发给配置工具
			try {
				if (cmdModel.getCmdType() != 3 ) {
					for (Map.Entry<String, Channel> entry : MeisSetChannelMap.map.entrySet()) {
						Channel channel = entry.getValue();
						ChannelHandler handle = channel.pipeline().get("setserverhandler");
						MeisSetSocketServerInHandler mHandler = (MeisSetSocketServerInHandler) handle;
						mHandler.mctx.writeAndFlush(Unpooled.copiedBuffer(reqtemp));
						HzzxLogger.debug("转发至配置" + CmdUtils.ByteArrayToHexString(reqtemp), "NettyLog");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				HzzxLogger.error("转发失败", e, "NettyLog");
			}

			switch (cmdModel.getProtocolVersion()) {
			case 0:// 老采集器协议用hospitalID+deviceID
				strKey = String.valueOf(cmdModel.getHospitalID()) + "_" + String.valueOf(cmdModel.getDeviceID());
				if (MeisCmdVersionMap.get(strKey) == -1) {
					MeisCmdVersionMap.add(strKey, 0);
				}
				if (MeisChannelMap.get(strKey) == null) {
					MeisChannelMap.add(strKey, ctx.channel());
				}
				HzzxLogger.debug(
						"MeisSocketServerInHandler:channelRead" + "收到原始指令：" + CmdUtils.ByteArrayToHexString(req),
						strKey);
				break;
			case 1:// 新采集器协议 用WiFi的Mac地址作为主键
				strKey = cmdModel.getWifiMac();
				if (MeisCmdVersionMap.get(strKey) == -1) {
					MeisCmdVersionMap.add(strKey, 1);
				}
				if (MeisChannelMap.get(strKey) == null) {
					MeisChannelMap.add(strKey, ctx.channel());
				}
				HzzxLogger.debug(
						"MeisSocketServerInHandler:channelRead" + "收到原始指令：" + CmdUtils.ByteArrayToHexString(req),
						strKey);
				break;
			default:
				strKey = cmdModel.getWifiMac();
				if (MeisCmdVersionMap.get(strKey) == -1) {
					MeisCmdVersionMap.add(strKey, 1);
				}
				if (MeisChannelMap.get(strKey) == null) {
					MeisChannelMap.add(strKey, ctx.channel());
				}
				HzzxLogger.debug(
						"MeisSocketServerInHandler:channelRead" + "收到原始指令：" + CmdUtils.ByteArrayToHexString(req),
						strKey);
				break;
			}
			mHospitalId = String.valueOf(cmdModel.getHospitalID());
			mDeviceID = String.valueOf(cmdModel.getDeviceID());
			mWifiMac = cmdModel.getWifiMac();
			// 根据心跳，当状态发生改变时，更新mongodb数据库中online设备当前状态工作，保存设备的在线不在线
			if (!isSaveOnline) {
				ClientOnLine clientOnLine = new ClientOnLine();
				clientOnLine.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				clientOnLine.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				clientOnLine.setHospitalId(String.valueOf(cmdModel.getHospitalID()));
				clientOnLine.setDeviceId(String.valueOf(cmdModel.getDeviceID()));
				clientOnLine.setValue("1");
				clientOnLine.setTickNum(0);
				clientOnLine.setEventTime(new Date());
				clientOnLine.setWifiMac(cmdModel.getWifiMac());
				clientOnLine.setEventID("Equipment_Online_ByBoard");
				clientOnLineDao.insertDemo(clientOnLine);
				isSaveOnline = true;
			}
			// 获取需要校验的字节数组
			byte[] b = new byte[req.length - 8];
			System.arraycopy(req, 2, b, 0, b.length);

			int c = CRC16Util.GetCrcValue(req, 2, req.length - 8);
			// HzzxLogger.debug("MeisSocketServerInHandler:channelRead" + "计算校验码：" + c
			// ,strKey);
			// System.out.println("计算校验码：" + c);
			byte[] returnByte = null;
			if (CmdUtils.ByteArray2ToInteger(cmdModel.getCrcByte(), 0) == c) {
				// System.out.println("校验通过");
				HzzxLogger.debug("MeisSocketServerInHandler:channelRead" + "校验通过", strKey);

				returnByte = CmdFactory.GenerateReturnCmdByte(req, true);// 获取采集器反馈指令
				// 判断当前指令是否采集器反馈指令
				if (cmdModel.getCmdType() == 4 || cmdModel.getCmdType() == 5 || cmdModel.getCmdType() == 2) {
					// 如果是反馈指令，并且再指令集合中存在，则移除指令集合中的相同指令
					if (CmdidList.contains(cmdModel.getCmd())) {
						isreceiveback = true;
						synchronized (listLock) {
							CmdidList.removeIf(cmdvalue -> cmdvalue == cmdModel.getCmd());
						}

					}
				}
			} else {
				HzzxLogger.debug("MeisSocketServerInHandler:channelRead" + "校验不通过", strKey);
				// System.out.println("校验不通过");
				returnByte = CmdFactory.GenerateReturnCmdByte(req, false);
			}

			// 如果收到的指令是采集器主动发送的，则发送反馈指令
			if (cmdModel.getCmdType() == 3) {

				boolean isNeedBack = true;
				// 针对部分指令主动指令，没有必要进行反馈，在这里处理下
				if (cmdModel.getCmd().getCmdId() >= 0x0302 && cmdModel.getCmd().getCmdId() <= 0x0308) {
					isNeedBack = false;
				}
				if (cmdModel.getCmd().getCmdId() >= 0x0402 && cmdModel.getCmd().getCmdId() <= 0x0419) {
					isNeedBack = false;
				}
				if (cmdModel.getCmd().getCmdId() == 0x0201) {
					isNeedBack = false;
				}
				if (cmdModel.getCmd().getCmdId() == 0x0382) {
					isNeedBack = false;
				}

				if (isNeedBack) {
					SendMsg(ctx, returnByte);

				}
			}
			// 将解析好的指令交给下一个handel处理
			ctx.fireChannelRead(cmdModel);
		} catch (Exception e) {
			HzzxLogger.error("指令处理异常："+CmdUtils.ByteArrayToHexString(reqtemp), e, strKey);
		}
	}

	/**
	 * 发送经过转义的指令
	 * 
	 * @param ctx
	 * @param sendbyte
	 */
	public void SendMsg(ChannelHandlerContext ctx, byte[] sendbyte) {
		// 通过channel发送反馈消息，注意 发送数据时要进行转义处理，
		String originalresult = CmdUtils.ByteArrayToHexString(sendbyte);
		String tempString = originalresult.replaceAll("aa 55", "").replaceAll("33 cc", "");
		tempString = tempString.replaceAll("aa", "aa ff ").replaceAll("33", "33 ff ");
		String finalstring = "aa 55 " + tempString + " 33 cc";
		// 将字符串中的多余空格去除，每个字符串之间保留一个空格即可
		finalstring = finalstring.replaceAll("[\\s]{2,}", " ");
		sendbyte = CmdUtils.HexStringToByteArray(finalstring, " ");
		ctx.writeAndFlush(Unpooled.copiedBuffer(sendbyte));
		HzzxLogger.debug("MeisSocketServerInHandler:channelRead" + "发送反馈指令：" + CmdUtils.ByteArrayToHexString(sendbyte),
				strKey);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}

	/**
	 * 注：Netty内部心跳机制使用userEventTriggered事件方式实现，服务端的心跳实现服务端清除多余链接的功能。
	 * 
	 */
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		try {
			if (evt instanceof IdleStateEvent) {
				IdleStateEvent event = (IdleStateEvent) evt;
				if (event.state() == IdleState.READER_IDLE) {
					/* 读超时则关闭channel */
					HzzxLogger.info("MeisSocketServerInHandler:userEventTriggered 读超时", strKey);
					ctx.close();
				} else if (event.state() == IdleState.WRITER_IDLE) {
					/* 写超时 */
					HzzxLogger.info("MeisSocketServerInHandler:userEventTriggered 写超时", strKey);
				} else if (event.state() == IdleState.ALL_IDLE) {
					/* 总超时 */
					HzzxLogger.info("MeisSocketServerInHandler:userEventTriggered 总超时", strKey);
				}
			}

		} catch (Exception e) {
			// System.out.println("心跳检测异常：" + e.getMessage());
			HzzxLogger.error("心跳检测异常：", e, strKey);
		}
	}

	/**
	 * 通过http发送指令到采集器并等待采集器反馈。
	 * 
	 * @param ctx     传进来的对应通道号下面的ctx
	 * @param evt     要下发的命令字节
	 * @param tiemOut 多长时间没有收到采集器反馈消息，认为请求超时，tiemout以秒为单位
	 * @return 反馈采集器返回结果
	 * @throws InterruptedException
	 */
	public String WriteM(ChannelHandlerContext ctx, Object evt, CMDID cmd, int tiemout) throws InterruptedException {
		try {
			byte[] msg = (byte[]) evt;

			// 通过channel发送反馈消息，注意 发送数据时要进行转义处理，
			String originalresult = CmdUtils.ByteArrayToHexString(msg);
			String tempString = originalresult.replaceAll("aa 55", "").replaceAll("33 cc", "");
			tempString = tempString.replaceAll("aa", "aa ff ").replaceAll("33", "33 ff ");
			String finalstring = "aa 55 " + tempString + " 33 cc";
			// 将字符串中的多余空格去除，每个字符串之间保留一个空格即可
			finalstring = finalstring.replaceAll("[\\s]{2,}", " ");
			msg = CmdUtils.HexStringToByteArray(finalstring, " ");
			ctx.writeAndFlush(Unpooled.copiedBuffer(msg));

			synchronized (listLock) {
				CmdidList.add(cmd);
			}

			while (tiemout-- > 0) {
				if (isreceiveback) {
					isreceiveback = false;
					return ControllerEorrConstant.success;
				}
				Thread.sleep(1000);
			}
			isreceiveback = false;
		} catch (Exception e) {
			HzzxLogger.error("MeisSocketServerInHandler:WriteM 下发指令异常信息", strKey);
			return ControllerEorrConstant.httpRequestToBoardErr;
		}
		return ControllerEorrConstant.responseErr;
	}
}
