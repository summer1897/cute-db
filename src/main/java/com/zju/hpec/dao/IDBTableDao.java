package com.zju.hpec.dao;

import java.util.List;

import com.zju.hpec.domain.DBRecord;

/**
 *
 * @Description: 数据库表dao
 * @author hzduhao
 * @Date 2016年5月22日
 *
 */
public interface IDBTableDao {

	/**
	 * 获取当前数据库所有数据表
	 * @return 返回当前连接数据中所有数据表名称
	 */
	public List<String> getTables();
	
	/**
	 * 获取指定数据库中所有数据表
	 * @param dbname 数据库名称
	 * @return 返回dbname数据库中所有数据表名称
	 */
	public List<String> getTablesOfDb(String dbname);
	
	/**
	 * 获取某张表中的所有纪录
	 * @param tableName 数据表
	 * @return 返回tableName数据表中所有数据纪录
	 */
	public List<DBRecord> getAllRecords(String tableName);
}
