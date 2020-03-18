/**  

* <p>Title: MeisMD5Coder.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月11日  
* @version 1.0  
*/  
package com.hzzxkj.socket.meisSocket;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * @author    guoxinan
 * @date      2018年10月11日
 * @parameter 对指令进行MD5加密和解密
 * @return    返回值
 */
public class MeisMD5Coder extends ByteToMessageDecoder{
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if (in == null) {
			return;
		}
	}

}
