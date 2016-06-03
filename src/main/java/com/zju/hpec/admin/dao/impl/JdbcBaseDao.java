package com.zju.hpec.admin.dao.impl;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.pool.DruidDataSource;
import com.zju.hpec.admin.dao.IBaseDao;
import com.zju.hpec.utils.DefaultDbSourceFactory;

public class JdbcBaseDao implements IBaseDao{
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DefaultDbSourceFactory defaultDbSourceFactory;

	public DataSource getDataSource() {
		DruidDataSource dataSource = (DruidDataSource)defaultDbSourceFactory.newInstance();
//		System.out.println("dataSource: "+dataSource);
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}

	public Connection getConnection() {
		return null;
	}

}
