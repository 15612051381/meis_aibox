package com.hzzxkj.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.slf4j.Logger;

import com.hzzxkj.BootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 日志输出工具，封装了创建日志记录器等过程，方便实用
 * @author liujun
 */
public class HzzxLogger {

	private static String loggerPath = "d:\\hzzx\\";

	/**
	 * 静态初始化块，读取配置文件中的日志根目录，如果没有则使用默认目录
	 */
	static {
		Properties properties = new Properties();
		InputStream in = BootApplication.class.getResourceAsStream("/application.properties");// 加载application.properties资源文件，如果该文件在包内则加包名
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temppath =  properties.getProperty("logpath");
		if (temppath!=null) {
			loggerPath = temppath;
		}
	}
    /**
     * 封装生成debug日志
     * @param msg    日志内容
     * @param filename  文件夹名称
     */
	public static void debug(String msg, String filename) {

		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger(filename);
		logger.debug(msg+"\r\n");

	}

	/**
	 * 封装生成debug日志
	 * @param msg    日志内容
	 * @param filename  文件夹名称
	 */
	public static void debug(String msg) {
		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger("realtime");
		logger.debug(msg+"\r\n");
	}

	/**
     * 封装生成error日志
     * @param msg    日志内容
     * @param filename  文件夹名称
     */
	public static void error(String msg, String filename) {

		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger(filename);

		logger.error(msg+"\r\n");

	}

	/**
	 * 封装生成error日志
	 * @param msg    日志内容
	 */
	public static void error(String msg) {

		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger("realtime");

		logger.error(msg+"\r\n");

	}

	/**
     * 封装生成error日志
     * @param ex        错误对象
     * @param filename  文件夹名称
     */
	public static void error(Exception ex, String filename) {

		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger(filename);
        String msg = getExceptionAllinformation(ex);
		logger.error(msg+"\r\n");

	}
	
	/**
     * 封装生成error日志
     * @param ex        错误对象
     * @param filename  文件夹名称
     */
	public static void error(String msg ,Exception ex, String filename) {

		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger(filename);
		msg+="\r\n";
        msg += getExceptionAllinformation(ex);
		logger.error(msg+"\r\n");

	}
	
	
	/**
     * 封装生成info日志
     * @param msg    日志内容
     * @param filename  文件夹名称
     */
	public static void info(String msg, String filename) {
		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger(filename);
		logger.info(msg+"\r\n");
	}

	/**
	 * 封装生成info日志
	 * @param msg    日志内容
	 */
	public static void info(String msg) {
		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger("realtime");
		logger.info(msg+"\r\n");
	}

	/**
     * 封装生成warn日志
     * @param msg    日志内容
     * @param filename  文件夹名称
     */
	public static void warn(String msg, String filename) {
		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger(filename);
		logger.warn(msg+"\r\n");
	}

	/**
	 * 封装生成warn日志
	 * @param msg    日志内容
	 */
	public static void warn(String msg) {
		LoggerBuilder loggerBuilder = new LoggerBuilder();
		loggerBuilder.Path = loggerPath;
		Logger logger = loggerBuilder.getLogger("realtime");
		logger.warn(msg+"\r\n");
	}
	
	/**
	 * 获取错误类型中的详细信息
	 * @param ex
	 * @return
	 */
	 static String getExceptionAllinformation(Exception ex) {  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        PrintStream pout = new PrintStream(out);  
        ex.printStackTrace(pout);  
        String ret = new String(out.toByteArray());  
        pout.close();  
        try {  
             out.close();  
        } catch (Exception e) {  
        }  
        return ret;  
} 

}
