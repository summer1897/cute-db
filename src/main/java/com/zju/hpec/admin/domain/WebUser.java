package com.zju.hpec.admin.domain;

/**
 *
 * @Description: 存放登陆后用户临时会话
 * @author hzduhao
 * @Date 2016年5月29日
 *
 */
public class WebUser {

	private String userName;
	
	private ThreadLocal<WebUser> webUsers = new ThreadLocal<WebUser>();
	
	public String getUserId(){
		WebUser webUser = webUsers.get();
		if(null == webUser)
			return null;
		return webUser.getUserName();
	}
	
	public void setWebUser(WebUser webUser){
		webUsers.set(webUser);
	}
	public void remove(){
		webUsers.remove();
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName(){
		return this.userName;
	}
}
