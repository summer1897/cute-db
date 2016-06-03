package com.zju.hpec.admin.dao;

import java.sql.Connection;

import javax.sql.DataSource;

/**
 *
 * @Description: BaseDao
 * @author hzduhao
 * @Date 2016年5月31日
 *
 */
public interface IBaseDao {

	/**
	 * 获取数据源对象
	 * @return
	 */
	public DataSource getDataSource();
	
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public Connection getConnection();
}
