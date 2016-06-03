package com.zju.hpec.utils;

import javax.sql.DataSource;

/**
 *
 * @author hzduhao
 * @Date 2016年5月31日
 *
 */
public abstract class AbstractDbSourceFactory implements IDbSourceFactory{

	/**默认数据源连接池*/
	protected static final String DEFAUT_DBSOURCE = "druidDataSource";
	
	public DataSource newInstance(){
		return newInstance(DEFAUT_DBSOURCE);
	}
	
	public abstract DataSource newInstance(String source);
}

