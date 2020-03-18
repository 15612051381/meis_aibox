package com.hzzxkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.hzzxkj.socket.meisJavaSocket.MeisJavaSocketServer;
import com.hzzxkj.socket.meisSetSocket.MeisSetSocketServer;
import com.hzzxkj.socket.meisSocket.MeisSocketServer;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@MapperScan("com.hzzxkj.dao")
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class BootApplication {

	public static ApplicationContext applicationContext;
	  
	public static void main(String[] args) throws Exception {
		applicationContext = SpringApplication.run(BootApplication.class, args);
		SpringBeanUtil.setApplicationContext(applicationContext);
		System.out.println("程序启动完毕");
		Thread thread  = new Thread(new Runnable() {
			@Override
			public void run() {
				MeisSetSocketServer setserver = new MeisSetSocketServer(LoadinProperties.configport);
				setserver.start(); 
			}
		});
		thread.setDaemon(true);
		thread.start();
		
		Thread javathread  = new Thread(new Runnable() {
			@Override
			public void run() {
				MeisJavaSocketServer setserver = new MeisJavaSocketServer(LoadinProperties.javaport);
				setserver.start(); 
			}
		});
		javathread.setDaemon(true);
		javathread.start();
		
		MeisSocketServer server =  new MeisSocketServer(LoadinProperties.meisseverport);
		server.start();

	} 
//	@SuppressWarnings("unused")
//	private static void readDb(MytableMapper mapper) {
//		// 读取数据库
//		int offset = 100;
//		int limit = 25;
//		RowBounds rowBounds = new RowBounds(offset, limit);
//		MytableExample example = new MytableExample();
//		java.util.List<Mytable> mts = mapper.selectByExample(example);
//		for (Mytable mt : mts) {
//			System.out.println(mt.getName());
//		}
//	}
//
//	@SuppressWarnings("unused")
//	private static void writeDb(MytableMapper mapper) {
//		// 插入数据库
//		for (int i = 1; i < 100; i++) {
//			Mytable tMytable = new Mytable();
//			tMytable.setName("AAAA" + (int) i);
//			mapper.insert(tMytable);
//			System.out.println(tMytable.getName());
//		}
//	}
}
