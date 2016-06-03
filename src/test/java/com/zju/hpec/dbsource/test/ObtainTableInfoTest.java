package com.zju.hpec.dbsource.test;

import java.sql.Connection;
import java.sql.ResultSet;
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
 * @Description: 获取表创建信息测试
 * @author hzduhao
 * @Date 2016年5月27日
 *
 */
public class ObtainTableInfoTest {

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
	public void obainTableinfoTest() throws SQLException{
		String sql = "show create table address";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getObject(2));
		}
	}
	
	@After
	public void destroy() throws SQLException{
		if(null != con)
			con.close();
	}
}
