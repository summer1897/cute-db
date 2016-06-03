package com.zju.hpec.domain;

import java.util.List;

/**
 *
 * @Description: 数据库纪录
 * @author hzduhao
 * @Date 2016年5月26日
 *
 */
public class DBRecord {

	private List<DBField> fields;
	public DBRecord(List<DBField> fields){
		this.fields = fields;
	}
	public void setFields(List<DBField> fields){
		this.fields = fields;
	}
	public List<DBField> getFields(){
		return this.fields;
	}
}
