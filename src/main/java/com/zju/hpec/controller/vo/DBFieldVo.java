package com.zju.hpec.controller.vo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/13
 * Time: 11:45
 */
public class DBFieldVo implements Serializable {

   
	private static final long serialVersionUID = 5099154157520856991L;
	
	/**字段值*/
    private Object value;

    public DBFieldVo() {}

    public DBFieldVo(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
