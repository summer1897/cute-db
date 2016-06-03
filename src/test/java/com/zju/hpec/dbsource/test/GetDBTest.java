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
 * @Description: 测试获取当前连接数据库中所有数据库名称
 * @author hzduhao
 * @Date 2016年5月29日
 *
 */
public class GetDBTest {

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
	public void getDBTest() throws SQLException{
		Statement st = con.createStatement();
		String sql = "show databases";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getObject(1));
		}
	}
	
	@After
	public void after() throws SQLException{
		if(null != con)
			con.close();
	}
}
