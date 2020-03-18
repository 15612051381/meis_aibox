/**  

* <p>Title: MeisCmdCoder.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月9日  
* @version 1.0  
*/
package com.hzzxkj.socket.meisSetSocket;

import java.util.ArrayList;
import java.util.List;

import com.hzzxkj.Logger.HzzxLogger;
import com.hzzxkj.cmdAnaliser.CmdUtils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 通道读取数据的编码器，将字节数组解码为需要的格式
 * @author guoxinan
 * @date 2018年10月9日
 
 */
public class MeisSetCmdCoder extends ByteToMessageDecoder {

	boolean headflag1 = false;
	boolean headflag2 = false;
	
	ArrayList<Byte> msg = new ArrayList<Byte>();
	/**
	 *将通道内的缓存数据按照帧协议格式 截取
	 */
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if (in == null) {
			return;
		}
		byte currentByte;
		// 建立一个字节集合存储已放入的数据 
		try {
			for (int i = 0; i < in.readableBytes(); i++) {
				currentByte = in.readByte();
				switch (currentByte) {
				case (byte) 0xaa:
					if (!headflag1) // 还未接收到0X55
					{
						msg.add(currentByte);
						headflag1 = true;
					} else // 已经接收到0x55
					{
						if (!headflag2) // 还未接收到0xaa
						{
							msg.clear(); // 创建临时帧数据
							msg.add(currentByte);
							headflag1 = true;
						} else // 已经接收到0xaa 表示帧头已经接收完全
						{
							msg.add(currentByte); // 将数据加入到临时帧数据数据中
						}
					}
					break;
				case (byte) 0x55:
					if (headflag1) // 已经接收到0x55
					{
						if (!headflag2) // 未接收到0xaa
						{
							msg.add(currentByte);
							headflag2 = true;
						} else // 已经接收到0xaa
						{
							msg.add(currentByte); // 将数据加入到临时帧数据数据中
						}
					} else // 未接收到0x55
					{
						msg.clear();
						headflag1 = false;
						headflag2 = false;

					}
				   break;
				case (byte) 0xCC:
					if (headflag1 && headflag2) {
						if (msg.get(msg.size() - 1) == (byte)0x33) {
							
							msg.add(currentByte); // 完整数据帧取出  
						    byte[] result = CmdUtils.ListToArray(msg);  
							out.add(result); 
							msg.clear();
							
						} else {//CC前面不是33，则认为是数据cc直接添加
							msg.add(currentByte);
						}

					} else {
						msg.clear();
					}
				break;
				default:
					if (headflag1 && headflag2) {
						msg.add(currentByte);
					} else {
						msg.clear();
					}
					break;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.clear();
		}  
	} 
}
