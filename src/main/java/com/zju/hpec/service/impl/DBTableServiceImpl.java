package com.zju.hpec.service.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.StringUtils;
import com.zju.hpec.service.dto.DBRecordDto;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOG = LoggerFactory.getLogger(DBTableServiceImpl.class);
	
	@Autowired
	private IDBTableDao dbTableDao;

	public List<String> getTables() {
		return dbTableDao.getTables();
	}

	public List<String> getTablesOfDb(String dbname) {

		if(StringUtils.isEmpty(dbname)){
			Collections.emptyList();
		}

		return dbTableDao.getTablesOfDb(dbname);
	}

	public List<DBRecordDto> getAllRecords(String tableName) {

		if(StringUtils.isEmpty(tableName)){
			Collections.emptyList();
		}

		List<DBRecordDto> dbRecordDtoList = Lists.newArrayList();

		List<DBRecord> dbRecordList = dbTableDao.getAllRecords(tableName);

		if(CollectionUtils.isNotEmpty(dbRecordList)){
			dbRecordDtoList.addAll(BeanCloneUtils.deepClone(dbRecordList,DBRecord.class,DBRecordDto.class));
		}

		return dbRecordDtoList;
	}

	public List<String> queryTablesMatchesName(String tableName) {
		if(StringUtils.isEmpty(tableName)){
			Collections.emptyList();
		}
		return dbTableDao.queryTablesMatchesName(tableName);
	}

	public List<String> queryTablesMatchesName(String dbName, String tableName) {
		if(StringUtils.isEmpty(dbName) || StringUtils.isEmpty(tableName)){
			Collections.emptyList();
		}

		return dbTableDao.queryTablesMatchesName(dbName,tableName);
	}

	public String getTableCreateInfo(String tableName) {
		if(StringUtils.isEmpty(tableName)){
			Collections.emptyList();
		}

		return dbTableDao.getTableCreateInfo(tableName);
	}

}
