package com.hzzxkj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadinProperties {

	/**
	 * 连接mysql驱动
	 */
	public static String mysqldriver;
	/**
	 * 连接mysql连接串
	 */
	public static String mysqlurl;
	/**
	 * 连接mysql用户名
	 */
	public static String mysqlusername;
	/**
	 * mysql数据库密码
	 */
	public static String mysqlpassword;

	/**
	 * 连接sql数据驱动
	 */
	public static String sqlserverdriver;
	/**
	 * 连接sql数据库的连接串
	 */
	public static String sqlserverurl;
	/**
	 * 连接sql数据库用户名
	 */
	public static String sqlserverusername;
	/**
	 * 连接数据库密码
	 */
	public static String sqlserverpassword;

	/**
	 * mongodb数据库
	 */
	public static String springapplicationname;
	/**
	 * 连接mongodb数据库连接串
	 */
	public static String springdatamongodburi;

	/**
	 * 日志路径
	 */
	public static String logpath;
    /**
             * 中专服务端口
     */
	public static int meisseverport;
   
	/**
	 * 配置工具连接端口
	 */
	public static int configport;
	/**
	 * tcp断开连接时间限制
	 */
	public static int Tcptimeout;
	
	public static int javaport;
	
/**
 * 同步rtc时间间隔，小时为单位
 */
	public static int asyncTimeFrequency;
	
	static {
		Properties properties = new Properties();
		InputStream in = BootApplication.class.getResourceAsStream("/application.properties");// 加载application.properties资源文件，如果该文件在包内则加包名
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (properties.containsKey("logpath")) {
			logpath = properties.getProperty("logpath");
		} else {
			logpath = "d:\\hzzx\\";
		}

		if (properties.containsKey("mysql.driver")) {
			mysqldriver = properties.getProperty("mysql.driver");
		} else {
			mysqldriver = "com.mysql.jdbc.Driver";
		}

		if (properties.containsKey("mysql.url")) {
			mysqlurl = properties.getProperty("mysql.url");
		} else {
			mysqlurl = "jdbc:mysql://localhost:3306/equipmentmanagement?characterEncoding=utf-8";
		}

		if (properties.containsKey("mysql.username")) {
			mysqlusername = properties.getProperty("mysql.username");
		} else {
			mysqlusername = "root";
		}

		if (properties.containsKey("mysql.password")) {
			mysqlpassword = properties.getProperty("mysql.password");
		} else {
			mysqlpassword = "bjhzzxadmin";
		}

		if (properties.containsKey("sqlserver.driver")) {
			sqlserverdriver = properties.getProperty("sqlserver.driver");
		} else {
			sqlserverdriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		}

		if (properties.containsKey("sqlserver.url")) {
			sqlserverurl = properties.getProperty("sqlserver.url");
		} else {
			sqlserverurl = "jdbc:sqlserver://localhost:1433;databaseName=meis_server";
		}

		if (properties.containsKey("sqlserver.username")) {
			sqlserverusername = properties.getProperty("sqlserver.username");
		} else {
			sqlserverusername = "sa";
		}

		if (properties.containsKey("sqlserver.password")) {
			sqlserverpassword = properties.getProperty("sqlserver.password");
		} else {
			sqlserverpassword = "sa";
		}

		if (properties.containsKey("spring.application.name")) {
			springapplicationname = properties.getProperty("spring.application.name");
		} else {
			springapplicationname = "spring-boot-mongodb";
		}

		if (properties.containsKey("spring.data.mongodb.urir")) {
			springdatamongodburi = properties.getProperty("spring.data.mongodb.uri");
		} else {
			springdatamongodburi = "mongodb://localhost:27017/meis_server";
		}
		
		if (properties.containsKey("logpath")) {
			logpath = properties.getProperty("logpath");
		} else {
			logpath = "d:\\hzzx\\";
		}
		
		if (properties.containsKey("meissever.port")) {
			meisseverport = Integer.valueOf(properties.getProperty("meissever.port"));
		} else {
			meisseverport = 7000;
		}
		
		if (properties.containsKey("config.port")) {
			configport = Integer.valueOf(properties.getProperty("config.port"));
		} else {
			configport = 7002;
		}
		
		
		if (properties.containsKey("asyncTimeFrequency")) {
			asyncTimeFrequency = Integer.valueOf(properties.getProperty("asyncTimeFrequency"));
		} else {
			asyncTimeFrequency = 24;
		}
		
		if (properties.containsKey("Tcptimeout")) {
			Tcptimeout = Integer.valueOf(properties.getProperty("Tcptimeout"));
		} else {
			Tcptimeout = 60;
		}
		
		if (properties.containsKey("java.port")) {
			javaport = Integer.valueOf(properties.getProperty("java.port"));
		} else {
			javaport = 7010;
		}
	}

}
