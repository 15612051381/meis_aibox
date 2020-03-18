package com.hzzxkj.socket.meisSetSocket;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.hzzxkj.Logger.HzzxLogger;
import com.hzzxkj.cmdAnaliser.CMDID;
import com.hzzxkj.cmdAnaliser.CRC16Util;
import com.hzzxkj.cmdAnaliser.CmdFactory;
import com.hzzxkj.cmdAnaliser.CmdModel;
import com.hzzxkj.cmdAnaliser.CmdUtils;
import com.hzzxkj.controller.ControllerEorrConstant;
import com.hzzxkj.socket.meisSocket.MeisChannelMap;
import com.hzzxkj.socket.meisSocket.MeisSocketServerInHandler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import javassist.expr.NewArray;

/**
 * 对通道接收到的数据进行处理
 * 
 * @author guoxinan
 * @date 2018年10月9日
 * @parameter channel对应的handler
 * @return
 */
public class MeisSetSocketServerInHandler extends ChannelHandlerAdapter {

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

	/**
	 * 用于保存每台设备连接时的key
	 */
	String strKey = "setNettyLog";

	@Override
	/**
	 * 在channel被启用的时候触发 (在建立连接的时候)
	 */
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		mctx = ctx;
		CmdidList = new ArrayList<CMDID>();
		strKey = ctx.channel().remoteAddress().toString();
		MeisSetChannelMap.add(strKey, ctx.channel());
		
		HzzxLogger.info("MeisSetSocketServerInHandler:channelActive" + "客户端IP：" + ctx.channel().remoteAddress()
				+ "连接成功，当前MeisSetChannelMap连接数量：" + String.valueOf(MeisSetChannelMap.getSize()), "setNettyLog");
	    
	}

	@Override
	/**
	 * channel失效处理,客户端下线或者强制退出等任何情况都触发这个方法
	 */
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// 通过Channel找到对应Channel的key，通过Channel的key找到采集器协议版本，找到则移除

		String cmdKey = MeisSetChannelMap.getMapKey(ctx.channel());
		if (cmdKey == null) {
			HzzxLogger.info("MeisSetSocketServerInHandler:channelInactive" + "客户端：" + ctx.channel().remoteAddress()
					+ "断开连接，连接未通讯，所以MeisSetChannelMap实际没有增加，当前MeisSetChannelMap中数量："
					+ String.valueOf(MeisSetChannelMap.getSize()), "setNettyLog");
		} else {
			HzzxLogger.info("MeisSetSocketServerInHandler:channelInactive" + "客户端：" + cmdKey + "断开连接，当前MeisSetChannelMap连接数量："
					+ String.valueOf(MeisSetChannelMap.getSize() - 1), "setNettyLog");
		}

		MeisSetChannelMap.remove(ctx.channel());

	}

	@Override
	/**
	 * 读取channel的pipeline列表中由上一个handle处理完后out出来的数据,
	 * 对接收到的数据进行crc校验及反馈，并将当前设备的唯一号和协议版本添加到cmdversionmap中
	 */
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			byte[] req = (byte[]) msg;

			// 接受数据时 要去除字节中的转义符后再进行校验
			String original = CmdUtils.ByteArrayToHexString(req).replaceAll("aa ff", "aa").replaceAll("33 ff", "33");
			req = CmdUtils.HexStringToByteArray(original, " ");
			
			CmdModel cmdModel = CmdFactory.CreateCmd(req);

			// 获取需要校验的字节数组
			byte[] b = new byte[req.length - 8];
			System.arraycopy(req, 2, b, 0, b.length);

			int c = CRC16Util.GetCrcValue(req, 2, req.length - 8);
			
			byte[] returnByte = null;
			if (CmdUtils.ByteArray2ToInteger(cmdModel.getCrcByte(), 0) == c) {
				
				HzzxLogger.debug("MeisSetSocketServerInHandler:channelRead" + "校验通过", "setNettyLog");

			} else {
				HzzxLogger.debug("MeisSetSocketServerInHandler:channelRead" + "校验不通过", "setNettyLog");
				
			}

			String key= "";
			switch (cmdModel.getProtocolVersion()) {
			case 0:
				key =String.valueOf( cmdModel.getHospitalID())+"_"+String.valueOf( cmdModel.getDeviceID());
				break;
			case 1:
				key = cmdModel.getWifiMac();
				break;
			default:
				key =String.valueOf( cmdModel.getHospitalID())+"_"+String.valueOf( cmdModel.getDeviceID());
				break;
			}
			
			Channel ch = MeisChannelMap.get(key);//根据传进来的设备ID得到缓存中记录的对应通道的map
			if (ch ==null) {
				HzzxLogger.debug("未找到"+key+"对应的channel", "setNettyLog");
			} else {
				ChannelHandler chd = ch.pipeline().get("serverhandler");//根据hander名称得到对应的channelHandler，目的是取handle中的属性和方法
				 
				MeisSocketServerInHandler chSocketServerhd = (MeisSocketServerInHandler)chd;//把得到的channelhandle对象强制转化为对应的MeisSocketServerInHandler，得到MeisSocketServerInHandler中的ctx
				
				chSocketServerhd.mctx.writeAndFlush(Unpooled.copiedBuffer(req));
				HzzxLogger.debug("转发消息至采集器"+key+":"+original, "setNettyLog");
			} 
		} catch (Exception e) {
			HzzxLogger.error("指令处理异常：", e, strKey);
		}
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
					HzzxLogger.info("MeisSetSocketServerInHandler:userEventTriggered 读超时", "setNettyLog");
					ctx.close();
				} else if (event.state() == IdleState.WRITER_IDLE) {
					/* 写超时 */
					HzzxLogger.info("MeisSetSocketServerInHandler:userEventTriggered 写超时", "setNettyLog");
				} else if (event.state() == IdleState.ALL_IDLE) {
					/* 总超时 */
					HzzxLogger.info("MeisSetSocketServerInHandler:userEventTriggered 总超时", "setNettyLog");
				}
			}

		} catch (Exception e) {
			// System.out.println("心跳检测异常：" + e.getMessage());
			HzzxLogger.error("心跳检测异常：", e, "setNettyLog");
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
			HzzxLogger.error("MeisSetSocketServerInHandler:WriteM 下发指令异常信息", "setNettyLog");
			return ControllerEorrConstant.httpRequestToBoardErr;
		}
		return ControllerEorrConstant.responseErr;
	}
}
