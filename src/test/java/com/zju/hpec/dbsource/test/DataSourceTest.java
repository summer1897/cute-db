package com.zju.hpec.dbsource.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

/**
 *
 * @Description: DruidDataSource数据源测试
 * @author hzduhao
 * @Date 2016年5月22日
 *
 */
public class DataSourceTest {

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
	public void testDataSource() throws SQLException {
		DatabaseMetaData metaData = con.getMetaData();
		ResultSet rs = metaData.getTables(null, "root", null, null);
		while(rs.next()){
			String tableName = rs.getString("TABLE_NAME");
			System.out.println(tableName);
		}
	}
}
