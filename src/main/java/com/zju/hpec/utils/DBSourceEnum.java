package com.zju.hpec.utils;

/**
 *
 * @Description: 数据源连接池
 * @author hzduaho
 * @Date 2016年5月31日
 *
 */
public enum DBSourceEnum {
	
	
	/**阿里巴巴的DruidDataSource数据库连接池*/
	DRUID_DBSOURCE("druid","com.alibaba.druid.pool.DruidDataSource"),
	/**Apache的dbcp数据库连接池*/
	DBCP_DBSOURCE("dbcp","org.apache.commons.dbcp.BasicDataSource"),
	/**c3p0数据库连接池*/
	C3P0_DBSOURCE("c3p0","com.mchange.v2.c3p0.ComboPooledDataSource");
	
	private String source;
	private String className;
	
	public String getSource(){
		return this.source;
	}
	public String getClassName(){
		return this.className;
	}
	
	public static String getClassName(String source){
		for(DBSourceEnum dbsource : DBSourceEnum.values()){
			if(dbsource.getSource().equals(source))
				return dbsource.getClassName();
		}
		return null;
	}
	
	DBSourceEnum(String source,String className){
		this.source = source;
		this.className = className;
	}
}
