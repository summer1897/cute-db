package com.zju.hpec.dbsource.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

/**
 *
 * @Description: 编程创建数据库测试
 * @author hzduhao
 * @Date 2016年5月27日
 *
 */
public class CreateDBTest {

	private static final String PATH = "classpath:config/spring-application-context.xml";
	private Connection con;

	@SuppressWarnings("resource")
	@Before
	public void before() throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext(PATH);
		// get data source
		DruidDataSource dbsource = (DruidDataSource) ac.getBean("dbsource");
		// get connection
		con = dbsource.getConnection();
	}
	
	@Test
	public void ceateDbTest() throws SQLException{
		Statement st = con.createStatement();
		st.addBatch("drop database if exists hello;");
		st.addBatch("create database if not exists hello;");
		int[] isSuccessful = st.executeBatch();
		if(null != isSuccessful)
		System.out.println("hello database create successfully!");
	}
	
	@After
	public void destory() throws SQLException{
		if(null != con)
			con.close();
	}
}
