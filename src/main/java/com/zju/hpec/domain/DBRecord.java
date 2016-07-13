package com.zju.hpec.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @Description: 数据库纪录
 * @author hzduhao
 * @Date 2016年5月26日
 *
 */
public class DBRecord implements Serializable{

	private static final long serialVersionUID = -3964336055317529734L;
	
	@JSONField(name = "dbFieldVoList")
	private List<DBField> fields;

	public DBRecord(){}

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
