package com.hzzxkj.socket.meisSocket;

import org.slf4j.Logger;

import com.hzzxkj.BootApplication;
import com.hzzxkj.Logger.HzzxLogger;
import com.hzzxkj.Logger.LoggerBuilder;
import com.hzzxkj.socket.meisSocket.MeisServerChannel;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * netty通信服务类
 * @author    guoxinan
 * @date      2018年10月9日
 */ 
public class MeisSocketServer {
	
	int port ;
	
	public  MeisSocketServer(int mPort) 
	{ 
	   this.port=mPort;
	}  
	
	private ChannelFuture f ;
	
	private ServerBootstrap b ;
	/**
	 * 启动通信服务监听
	 * @throws Exception 
	 */
	public void start()  {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					//日志级别
					//.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new  MeisServerChannel())
					// 连接数
					.option(ChannelOption.SO_BACKLOG, 128)
					// 长连接
					.childOption(ChannelOption.SO_KEEPALIVE, true)
					// 不延迟，消息立即发送
					.option(ChannelOption.TCP_NODELAY, true)
					// 接收系统缓冲区buf
					.option(ChannelOption.SO_RCVBUF, 8 * 1024)
					// 连接超时时间
					.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000);
					 
		    f = b.bind(port).sync();
			if (f.isSuccess()) {
				 HzzxLogger.info("MeisSocketServer:start" + "启动Netty服务成功，端口号：" + String.valueOf(this.port), "NettyLog"); 
				 //System.out.println("启动Netty服务成功，端口号：" + String.valueOf(this.port));  
			} 
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			 HzzxLogger.error("MeisSocketServer:start" + "启动Netty服务异常，异常信息：" , e, "NettyLog"); 
			 //System.out.println("启动Netty服务异常，异常信息：" +  e.getMessage()); 
			e.printStackTrace();
		} finally { 
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}  
    }
	/**
	 * 通信服务停止
	 */
    public void stopServer(){
        if(f!=null){
            f.channel().close();
        }
    }
    /* (non-Javadoc)
     * @see java.lang.Object#finalize()
     */
    @Override
    protected void finalize() throws Throwable {
    	// TODO Auto-generated method stub
    	super.finalize();
    	stopServer();
    }
     
}
