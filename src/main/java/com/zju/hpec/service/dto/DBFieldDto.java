package com.zju.hpec.service.dto;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/13
 * Time: 14:58
 */
public class DBFieldDto implements Serializable{

    private static final long serialVersionUID = -1096700299518606348L;

    /**字段名称*/
    private String fieldName;
    /**字段值*/
    private Object value;

    public DBFieldDto() {}

    public DBFieldDto(String fieldName, Object value) {
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
