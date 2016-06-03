package com.zju.hpec.admin.dao;

import com.zju.hpec.admin.domain.DBSource;

/**
 *
 * @Description: 数据源DAO
 * @author hzduhao
 * @Date 2016年5月29日
 *
 */
public interface IDBSourceDao {

	/**
	 * 验证该数据源能否连接
	 * @param dbSource 数据源
	 * @return 如果能连接返回true,否则返回fale
	 */
	public boolean canConnection(DBSource dbSource);
}
