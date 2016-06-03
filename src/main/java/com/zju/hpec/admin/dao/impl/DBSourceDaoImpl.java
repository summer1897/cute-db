package com.zju.hpec.admin.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.zju.hpec.admin.dao.IDBSourceDao;
import com.zju.hpec.admin.domain.DBSource;
import com.zju.hpec.consts.DBType;
import com.zju.hpec.utils.DBUtils;

@Repository
public class DBSourceDaoImpl extends JdbcBaseDao implements IDBSourceDao{
	
	public boolean canConnection(DBSource dbSource) {
//		System.out.println("dynamicDBSource: "+getDataSource());
		boolean flag = false;
		Connection con = null;
		try {
			Class.forName(DBType.getDriver(dbSource.getDbType()));
//			System.out.println(url);
			con = DriverManager.getConnection(DBUtils.resolveUrl(dbSource), dbSource.getUser(), dbSource.getPassword());
			flag = con != null;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null != con)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return flag;
	}

}
