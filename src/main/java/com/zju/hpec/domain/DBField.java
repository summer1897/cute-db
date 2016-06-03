package com.zju.hpec.domain;

/**
 *
 * @Description: 数据库字段实体对象
 * @author hzduhao
 * @Date 2016年5月26日
 *
 */
public class DBField {

	/**字段名称*/
	private String fieldName;
	/**字段值*/
	private Object value;
	public DBField() {
	}
	public DBField(String fieldName, Object value) {
		this.fieldName = fieldName;
		this.value = value;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
