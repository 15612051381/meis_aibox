package com.hzzxkj.socket.meisJavaSocket;

import java.util.ArrayList;
import java.util.List;

import com.hzzxkj.cmdAnaliser.CmdUtils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MeisJavaCmdCoder extends ByteToMessageDecoder {

	ArrayList<Byte> msg = new ArrayList<Byte>();
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
        
		if (in == null) {
			return;
		}

         int len =   in.readableBytes();
         if (len>0) {
        	 byte[] temp = new byte[len];
             in.readBytes(temp);
             //msg.addAll(CmdUtils.ArrayToList(temp));
             String tempmsg = CmdUtils.ByteArrayToNormalString(temp, 0, temp.length);
             out.add(tempmsg);
		}
        
		
		
		
	}

}
