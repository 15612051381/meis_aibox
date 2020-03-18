package com.hzzxkj.socket.meisJavaSocket;

import java.util.ArrayList;

import com.hzzxkj.Logger.HzzxLogger;
import com.hzzxkj.cmdAnaliser.CMDID;
import com.hzzxkj.cmdAnaliser.CRC16Util;
import com.hzzxkj.cmdAnaliser.CmdFactory;
import com.hzzxkj.cmdAnaliser.CmdModel;
import com.hzzxkj.cmdAnaliser.CmdUtils;
import com.hzzxkj.socket.meisSetSocket.MeisSetChannelMap;
import com.hzzxkj.socket.meisSocket.MeisChannelMap;
import com.hzzxkj.socket.meisSocket.MeisCmdVersionMap;
import com.hzzxkj.socket.meisSocket.MeisSocketServerInHandler;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class MeisJavaSocketServerInHandler extends ChannelHandlerAdapter {
	public ChannelHandlerContext mctx;

	/**
	 * 用于保存每台设备连接时的key
	 */
	String strKey = "JavaNettyLog";

	@Override
	/**
	 * 在channel被启用的时候触发 (在建立连接的时候)
	 */
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		mctx = ctx;

		strKey = ctx.channel().remoteAddress().toString();
		MeisJavaChannelMap.add(strKey, ctx.channel());

		HzzxLogger.info(
				"MeisJavaSocketServerInHandler:channelActive" + "客户端IP：" + ctx.channel().remoteAddress()
						+ "连接成功，当前MeisJavaChannelMap连接数量：" + String.valueOf(MeisJavaChannelMap.getSize()),
				"javaNettyLog");

	}

	@Override
	/**
	 * channel失效处理,客户端下线或者强制退出等任何情况都触发这个方法
	 */
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// 通过Channel找到对应Channel的key，通过Channel的key找到采集器协议版本，找到则移除

		String cmdKey = MeisJavaChannelMap.getMapKey(ctx.channel());
		if (cmdKey == null) {
			HzzxLogger.info("MeisJavaSocketServerInHandler:channelInactive" + "客户端：" + ctx.channel().remoteAddress()
					+ "断开连接，连接未通讯，所以MeisJavaChannelMap实际没有增加，当前MeisJavaChannelMap中数量："
					+ String.valueOf(MeisJavaChannelMap.getSize()), "javaNettyLog");
		} else {
			HzzxLogger.info("MeisJavaSocketServerInHandler:channelInactive" + "客户端：" + cmdKey
					+ "断开连接，当前MeisJavaChannelMap连接数量：" + String.valueOf(MeisJavaChannelMap.getSize() - 1),
					"javaNettyLog");
		}

		MeisJavaChannelMap.remove(ctx.channel());

	}

	@Override
	/**
	 * 读取channel的pipeline列表中由上一个handle处理完后out出来的数据,
	 * 对接收到的数据进行crc校验及反馈，并将当前设备的唯一号和协议版本添加到cmdversionmap中
	 */
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			//获取接收到的信息
			String message = String.valueOf(msg);
			//拆分信息
			String[] strpars = message.split("\\|");// 注意 ，分割符为|时需要加转义符才能进行分割
			//获取医院id 设备id 和版本号
			int protocolversion = 0;
			int hospital_id=0;
			int device_id = 0;
			String key = "";
			if (strpars.length >= 3) {
				hospital_id= Integer.valueOf(strpars[1]);
				device_id= Integer.valueOf(strpars[2]);
			    key = strpars[1] + "_" + strpars[2];
				protocolversion =   MeisCmdVersionMap.get(key);
				if (protocolversion==-1) {
					protocolversion=0;
				}
			}
			//获取通信通道
			Channel ch = MeisChannelMap.get(key);//根据传进来的设备ID得到缓存中记录的对应通道的map
			byte[] cmdbyte;
			String hexstring = "";
			switch (strpars[0].toLowerCase()) {
			case "reportfault":
				if (strpars.length >= 3) {
					// 发送设置故障指令
					 ArrayList<Byte> databyte = new ArrayList<Byte>();
					 int stauts=1;
					 databyte.add(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(stauts)).get(0));
					 cmdbyte = CmdFactory.createcmd_SetAlterStatus(protocolversion, hospital_id, device_id, CmdUtils.ListToArray(databyte));
					 hexstring = CmdUtils.ByteArrayToHexString(cmdbyte);
				}
			break;
			case "clearfault":
				if (strpars.length >= 3) {
					// 发送清除故障指令
					 cmdbyte = CmdFactory.createcmd_ClearFaultStatus(protocolversion,hospital_id ,
							device_id, null);
					 hexstring = CmdUtils.ByteArrayToHexString(cmdbyte);
				}
				break;
			case "startwavedata":
				// 发送开启波形图指令
				ArrayList<Byte> databyte = new ArrayList<Byte>();
				int requirefre = Integer.valueOf(strpars[3]);
				databyte.add(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(requirefre)).get(0));
				int requireNum = Integer.valueOf(strpars[4]);
				databyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(requireNum)));
				int requireChannelNum = Integer.valueOf(strpars[5]);
				databyte.add(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(requireChannelNum)).get(0));
				String[] channellist = strpars[6].split(",");
				for (int i = 0; i < channellist.length; i++) {
					databyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(Integer.valueOf(channellist[i]))));

				}
				 cmdbyte = CmdFactory.createcmd_StartWavedata(protocolversion, hospital_id, device_id, CmdUtils.ListToArray(databyte));
				 hexstring = CmdUtils.ByteArrayToHexString(cmdbyte);
				 break;
			case "stopwavedata":
				// 发送关闭波形图指令
				if (strpars.length >= 3) {
					// 发送清除故障指令
				cmdbyte = CmdFactory.createcmd_StopWavedata(protocolversion,hospital_id ,
							device_id, null);
				hexstring = CmdUtils.ByteArrayToHexString(cmdbyte);
				}
				break;
			default:
				break;
			}

			if (ch ==null) {
				HzzxLogger.debug("未找到"+key+"对应的channel", "javaNettyLog");
			} else {
				ChannelHandler chd = ch.pipeline().get("serverhandler");//根据hander名称得到对应的channelHandler，目的是取handle中的属性和方法

				MeisSocketServerInHandler chSocketServerhd = (MeisSocketServerInHandler)chd;//把得到的channelhandle对象强制转化为对应的MeisSocketServerInHandler，得到MeisSocketServerInHandler中的ctx

				// 通过channel发送反馈消息，注意 发送数据时要进行转义处理，
				String originalresult = hexstring;
				String tempString = originalresult.replaceAll("aa 55", "").replaceAll("33 cc", "");
				tempString = tempString.replaceAll("aa", "aa ff ").replaceAll("33", "33 ff ");
				String finalstring = "aa 55 " + tempString + " 33 cc";
				// 将字符串中的多余空格去除，每个字符串之间保留一个空格即可
				finalstring = finalstring.replaceAll("[\\s]{2,}", " ");
				byte[] finalcmdbyte = CmdUtils.HexStringToByteArray(finalstring, " ");
				chSocketServerhd.mctx.writeAndFlush(Unpooled.copiedBuffer(finalcmdbyte));
				HzzxLogger.debug("发消息至采集器"+key+":"+finalstring, "javaNettyLog");
			}

		} catch (Exception e) {
			// TODO: handle exception
			HzzxLogger.error("java发送数据失败", e, "JavaNettyLog");
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
					HzzxLogger.info("MeisJavaSocketServerInHandler:userEventTriggered 读超时", "javaNettyLog");
					ctx.close();
				} else if (event.state() == IdleState.WRITER_IDLE) {
					/* 写超时 */
					HzzxLogger.info("MeisJavaSocketServerInHandler:userEventTriggered 写超时", "javaNettyLog");
				} else if (event.state() == IdleState.ALL_IDLE) {
					/* 总超时 */
					HzzxLogger.info("MeisJavaSocketServerInHandler:userEventTriggered 总超时", "javaNettyLog");
				}
			}

		} catch (Exception e) {
			// System.out.println("心跳检测异常：" + e.getMessage());
			HzzxLogger.error("心跳检测异常：", e, "javaNettyLog");
		}
	}
}
