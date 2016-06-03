package com.zju.hpec.domain;

/**
 *
 * @Description: 数据库元数据
 * @author hzduhao
 * @Date 2016年5月24日
 *
 */
public class DatabaseMetaData {

	private int id;
	/**数据库类型目前支持MySQL,Oracle,DB2,SQLServer*/
	private String type;
	/**数据库驱动*/
	private String driver;
	/**数据库连接URL地址*/
	private String url;
	/**数据库连接登陆用户名*/
	private String user;
	/**数据库连接登陆密码*/
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
}
