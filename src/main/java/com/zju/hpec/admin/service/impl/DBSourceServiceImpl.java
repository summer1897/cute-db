package com.zju.hpec.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zju.hpec.admin.dao.IDBSourceDao;
import com.zju.hpec.admin.domain.DBSource;
import com.zju.hpec.admin.service.IDBSourceService;

@Service
public class DBSourceServiceImpl implements IDBSourceService {

	@Autowired
	private IDBSourceDao dbSourceDao;
	
	public boolean canConnection(DBSource dbSource) {
		return dbSourceDao.canConnection(dbSource);
	}

}
