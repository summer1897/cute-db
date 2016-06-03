package com.zju.hpec.utils;

import javax.sql.DataSource;

/**
 *
 * @Description: 数据源工厂
 * @author hzduhao
 * @Date 2016年5月31日
 *
 */
public interface IDbSourceFactory {

	/**
	 * 获取默认数据源
	 * @return {@link DatSource}
	 */
	public DataSource newInstance();
	
	/**
	 * 获取指定类型的数据源
	 * @param source 数据源类型
	 * @return {@link DatSource}
	 */
	public DataSource newInstance(String source);
}
