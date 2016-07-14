package com.zju.hpec.controller.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/13
 * Time: 11:44
 */
public class DBRecordVo implements Serializable {

	private static final long serialVersionUID = 6997089045838128439L;
	
	private List<DBFieldVo> dbFieldVoList;

    public DBRecordVo(){}

    public DBRecordVo(List<DBFieldVo> dbFieldVoList){
        this.dbFieldVoList = dbFieldVoList;
    }

    public List<DBFieldVo> getDbFieldVoList() {
        return dbFieldVoList;
    }

    public void setDbFieldVoList(List<DBFieldVo> dbFieldVoList) {
        this.dbFieldVoList = dbFieldVoList;
    }
}
