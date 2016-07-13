package com.zju.hpec.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zju.hpec.controller.Sqls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Repository;

import com.zju.hpec.dao.IDBTableDao;
import com.zju.hpec.domain.DBRecord;
import com.zju.hpec.utils.DBUtils;

/**
 *
 * @Description: 
 * @author hzduhao
 * @Date 2016年5月24日
 *
 */
@Repository
public class DBTableDaoImpl implements IDBTableDao {

	private static final Logger LOG = LoggerFactory.getLogger(ISqlOperationDao.class);

	private static final String TABLE_NAME = "TABLE_NAME";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> getTables() {
		return getTablesOfDb(null);
	}

	public List<String> getTablesOfDb(String dbname) {
		List<String> tables = new ArrayList<String>();
		DatabaseMetaData metaData = null;
		ResultSet rs = null;
		try {
			metaData = DBUtils.getDatabaseMetaDat(jdbcTemplate);
			 rs = metaData.getTables(dbname, null, null, null);
			while(rs.next()){
				tables.add(rs.getString(TABLE_NAME));
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}finally {
			DBUtils.close(null,null,rs);
		}
		return tables;
	}

	public List<DBRecord> getAllRecords(String tableName) {
		StringBuilder sql = new StringBuilder("select * from ");
		sql.append(tableName);
		return jdbcTemplate.query(sql.toString(), new RowMapperDBRecord());
	}

	public List<String> queryTablesMatchesName(String tableName) {
		return queryTablesMatchesName(null,tableName);
	}

	public List<String> queryTablesMatchesName(String dbName, String tableName) {
		List<String> tables = new ArrayList<String>();

		DatabaseMetaData metaData = null;
		ResultSet rs = null;
		try{
			metaData = DBUtils.getDatabaseMetaDat(jdbcTemplate);
			rs = metaData.getTables(dbName,null,tableName,null);
			while(rs.next()){
				tables.add(rs.getString(TABLE_NAME));
			}
		}catch(SQLException e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}finally {
			DBUtils.close(null,null,rs);
		}
		return tables;
	}

	public String getTableCreateInfo(String tableName) {
		String tableInfo = "";
		final String sql = Sqls.SHOW_CREATE_TABLE + tableName;
		tableInfo = jdbcTemplate.execute(new StatementCallback<String>() {
			public String doInStatement(Statement statement) throws SQLException, DataAccessException {
				StringBuilder result = new StringBuilder("");
				ResultSet rs = statement.executeQuery(sql);

				while(rs.next()){
					if(null != rs.getObject(2))
						result.append(rs.getObject(2).toString());
				}
				return result.toString();
			}
		});
		return tableInfo;
	}

}
