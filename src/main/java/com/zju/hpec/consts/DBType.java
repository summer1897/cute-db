package com.zju.hpec.consts;

/**
 *
 * @Description: 数据库类型
 * @author hzduhao
 * @Date 2016年5月24日
 *
 */
public enum DBType {

	/**MySQL数据库连接*/
	MYSQL("MYSQL","com.mysql.jdbc.Driver","jdbc:mysql://host:port/dbName?useUnicode=unicode&characterEncoding=charset"),
	/**Oracle数据库连接*/
	ORACLE("ORACLE","oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@//host:port/dbName?useUnicode=unicode&characterEncoding=charset"),
	/**一般用于连接SQLSever2000*/
	SQLSERVER_2000("SQLSERVER_URL_2000","com.microsoft.jdbc.sqlserver.SQLServerDriver","jdbc:microsoft:sqlserver://host:port/dbName??useUnicode=unicode&characterEncoding=charset"),
	/**一般用于连接SQLSever2005及更新版本*/
	SQLSERVER("SQLSERVER","com.microsoft.jdbc.sqlserver.SQLServerDriver","jdbc:sqlserver://host:port/dbName?useUnicode=unicode&characterEncoding=charset"),
	/**DB2数据库连接*/
	DB2("DB2","com.ibm.db2.jdbc.app.DB2Driver","jdbc:db2://host:port/dbName?useUnicode=unicode&characterEncoding=charset");
	
	/**数据库类型*/
	private String type;
	/**数据库对应的驱动*/
	private String driver;
	/**数据库连接URL*/
	private String url;
	
	public String getDriver(){
		return this.driver;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public static String getDriver(String type){
		for(DBType dbtype : DBType.values()){
			if(dbtype.getType().equals(type))
				return dbtype.getDriver();
		}
		return null;
	}
	
	public static String getUrl(String type){
		for(DBType dbtype : DBType.values()){
			if(dbtype.getType().equals(type))
				return dbtype.getUrl();
		}
		return null;
	}
	
	private DBType(String type,String driver,String url){
		this.type = type;
		this.driver = driver;
		this.url = url;
	}
}
