package com.zju.hpec.utils;

import java.sql.*;

import com.zju.hpec.admin.domain.DBSource;
import com.zju.hpec.consts.DBType;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @Description: 数据库工具类
 * @author hzduhao
 * @Date 2016年5月22日
 *
 */
public class DBUtils{
	
	private static final String HOST = "host";
	private static final String PORT = "port";
	private static final String DB_NAME = "dbName";
	private static final String USE_UNICODE = "unicode";
	private static final String CHARSET = "charset";

	public static final String DEFAULT_CHARSET = "UTF-8";
	
	public static String resolveUrl(DBSource dbSource){
		return DBType.getUrl(dbSource.getDbType())
				.replace(HOST, dbSource.getHost())
				.replace(PORT, dbSource.getPort())
				.replace(DB_NAME, dbSource.getDbName())
				.replace(USE_UNICODE, new Boolean(dbSource.isUseUnicode()).toString())
				.replace(CHARSET, dbSource.getCharset());
	}

	public static Connection getConnection(JdbcTemplate jdbcTemplate) {

		if(null == jdbcTemplate)
			return null;

		try {
			return jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static DatabaseMetaData getDatabaseMetaDat(JdbcTemplate jdbcTemplate){
		if(null == jdbcTemplate)
			return null;
		try {
			return jdbcTemplate.getDataSource()
                               .getConnection()
                               .getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection con,Statement statement,ResultSet rs){
		if(null != rs){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(null != statement){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(null != con){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
