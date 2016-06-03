package com.zju.hpec.admin.domain;

/**
 *
 * @Description: 数据源实体
 * @author hzduhao
 * @Date 2016年5月29日
 *
 */
public class DBSource {

	private String dbName;
	private String dbType;
	private String host;
	private String port;
	private String user;
	private String password;
	private boolean useUnicode;
	private String charset;
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isUseUnicode() {
		return useUnicode;
	}
	public void setUseUnicode(boolean useUnicode) {
		this.useUnicode = useUnicode;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
}
