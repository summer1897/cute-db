package com.zju.hpec.admin.domain;

/**
 *
 * @Description: 数据库表实体对象
 * @author hzduhao
 * @Date 2016年5月22日
 *
 */
public class Table {

	private String name;
	
	public Table(){}
	
	public Table(String name){
		this.name = name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}
