package com.hzzxkj.socket.meisSetSocket;
import com.hzzxkj.socket.meisSocket.MeisCmdCoder;
import com.hzzxkj.socket.meisSocket.MeisSocketServerInHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;


/**
 * netty通道类
 * @author    guoxinan
 * @date      2018年10月12日
 */
public class MeisSetServerChannel extends ChannelInitializer<SocketChannel>{ 
	 
	private String timeout="300"; 
	 
	// 检测chanel是否接受过心跳数据时间间隔（单位秒） 
    private static final int READ_WAIT_SECONDS = 10;
	
    /**
     * @author    guoxinan
     * @date      2018年10月9日
     * @parameter 初始化Channel，创建pipeline对象，对pipeline进行操作
     */
	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		//添加MD5解码
		//pipeline.addLast("MD5coder", new MeisMD5Coder());
		
		//加入自定义解码器 保证数据是以55 AA开头并且是33 cc结束的数据传输到Handler中
		pipeline.addLast("setCMDcoder", new MeisSetCmdCoder()); 
		
        //设置心跳检测超时时间
        //pipeline.addLast("pong", new IdleStateHandler(READ_WAIT_SECONDS, 0, 0,TimeUnit.SECONDS));
		//超时时间设置：300秒未接收到数据后，断开连接  
	    //超时handler（当服务器端与客户端在指定时间以上没有任何进行通信，则会关闭响应的通道，主要为减小服务端资源占用）
		//pipeline.addLast("setreadtime",new ReadTimeoutHandler(300));
		
		MeisSetSocketServerInHandler meisSocketServerInHandler = new MeisSetSocketServerInHandler(); 
		pipeline.addLast("setserverhandler",meisSocketServerInHandler);
		
	}
	/**
	 * @parameter 设置超时时间
	 * @return 返回超时时间
	 */
	private int timeout() {
		return Integer.parseInt(timeout);
		
	}
	
	
}
