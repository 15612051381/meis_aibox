/**  

* <p>Title: LoggerBuilder.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月13日  
* @version 1.0  
*/
package com.hzzxkj.Logger;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.hzzxkj.BootApplication;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.rolling.RollingFileAppender;

/**
 * logger工具类,将不同设备的日志输出到不同文件夹下
 * @author guoxinan
 * @date 2018年10月13日
 */
public class LoggerBuilder {
	private static final Map<String, Logger> container = new HashMap<>();
	public static  String Path = "d\\hzzxlog\\" ;
	
	/**
	 * 根据名称获得日志记录器
	 * @param name  名称
	 * @return    日志记录器
	 */
	
	public Logger getLogger(String name) {
		Logger logger = container.get(name);
		if (logger != null) {
			return logger;
		}
		synchronized (LoggerBuilder.class) {
			logger = container.get(name);
			if (logger != null) {
				return logger;
			}
			logger = build(name);
			container.put(name, logger);
		}
		return logger;
	}

	/**
	 * 构造一个日志记录器，实现了debug、error、info、warn4个级别的appender,并设置输出苏哟有级别的日志信息
	 * @param name  日志记录器名 即日志要写入的文件夹名称
	 * @return
	 */
	private static Logger build(String name) {
		RollingFileAppender debugAppender = new AppenderTest().getAppender(name, Level.DEBUG);
		RollingFileAppender errorAppender = new AppenderTest().getAppender(name, Level.ERROR);
		RollingFileAppender infoAppender = new AppenderTest().getAppender(name, Level.INFO);
		RollingFileAppender warnAppender = new AppenderTest().getAppender(name, Level.WARN);
		
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		
		Logger logger = context.getLogger("FILE-" + name);
		//設置logger輸出所有級別信息
		logger.setLevel(Level.ALL);
		// 设置不向上级打印信息
		logger.setAdditive(false);
		logger.addAppender(errorAppender);
		logger.addAppender(infoAppender);
		logger.addAppender(warnAppender);
		logger.addAppender(debugAppender);
        
		return logger;
	}
}
