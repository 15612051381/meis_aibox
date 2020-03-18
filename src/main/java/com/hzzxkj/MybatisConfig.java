//package com.hzzxkj;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//@Configuration
//@Lazy
//@PropertySource(value = { "classpath:application.properties" }, encoding = "UTF-8")
//public class MybatisConfig {
//	@Value("${sqlserver.driver}")
//	private String sqlserverdriverClassName;
//
//	@Value("${sqlserver.url}")
//	private String sqlserverurl;
//
//	@Value("${sqlserver.username}")
//	private String sqlserverusername;
//
//	@Value("${sqlserver.password}")
//	private String sqlserverpassword;
//
//
//	@Value("${mysql.driver}")
//	private String mysqldriverClassName;
//
//	@Value("${mysql.url}")
//	private String mysqlurl;
//
//	@Value("${mysql.username}")
//	private String mysqlusername;
//
//	@Value("${mysql.password}")
//	private String mysqlpassword;
//
//
//	// 配置sqlserver数据源
//	@Bean(name = "A", destroyMethod = "close")
//	public DataSource dataSource() {
//		BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.setDriverClassName(sqlserverdriverClassName);
//		basicDataSource.setUrl(sqlserverurl);
//		basicDataSource.setUsername(sqlserverusername);
//		basicDataSource.setPassword(sqlserverpassword);
//		return basicDataSource;
//	}
//
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
//		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//		fb.setDataSource(ds);
//		fb.setTypeAliasesPackage("com.hzzxkj");
//		/*
//		org.springframework.core.io.support.PathMatchingResourcePatternResolver recolver = new PathMatchingResourcePatternResolver();
//		org.springframework.core.io.Resource[] resources=recolver.getResources("classpath*:com/hzzxkj/mappers/*.xml");
//		fb.setMapperLocations(resources);
//
//			*/
//		fb.setMapperLocations(
//				new PathMatchingResourcePatternResolver().getResources("classpath*:com/hzzxkj/mappers/*.xml"));// 指定xml文件位
//
//		return fb.getObject();
//	}
//	//配置mysql数据源
//	@Bean(name = "A", destroyMethod = "close")
//	public DataSource mysqldataSource() {
//		System.out.println("---------");
//		BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.setDriverClassName(mysqldriverClassName);
//		basicDataSource.setUrl(mysqlurl);
//		basicDataSource.setUsername(mysqlusername);
//		basicDataSource.setPassword(mysqlpassword);
//		System.out.println("---------" + mysqldriverClassName);
//		return basicDataSource;
//	}
//
//	@Bean
//	public SqlSessionFactory mysqlSessionFactory(DataSource ds) throws Exception {
//		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//		fb.setDataSource(ds);
//		fb.setTypeAliasesPackage("com.hzzxkj");
//		fb.setMapperLocations(
//				new PathMatchingResourcePatternResolver().getResources("classpath*:com/hzzxkj/mappers/*.xml"));// 指定xml文件位
//		return fb.getObject();
//	}
//}
