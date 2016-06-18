package com.zju.hpec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zju.hpec.dao.IDBTableDao;
import com.zju.hpec.domain.DBRecord;
import com.zju.hpec.service.IDBTableService;

/**
 *
 * @Description: 
 * @author hzduhao
 * @Date 2016年5月24日
 *
 */
@Service
public class DBTableServiceImpl implements IDBTableService {
	
	@Autowired
	private IDBTableDao dbTableDao;

	public List<String> getTables() {
		return dbTableDao.getTables();
	}

	public List<String> getTablesOfDb(String dbname) {
		return dbTableDao.getTablesOfDb(dbname);
	}

	public List<DBRecord> getAllRecords(String tableName) {
		return dbTableDao.getAllRecords(tableName);
	}

	public List<String> queryTablesMatchesName(String tableName) {
		return dbTableDao.queryTablesMatchesName(tableName);
	}

	public List<String> queryTablesMatchesName(String dbName, String tableName) {
		return dbTableDao.queryTablesMatchesName(dbName,tableName);
	}

}
