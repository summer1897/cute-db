package com.zju.hpec.service.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/13
 * Time: 14:57
 */
public class DBRecordDto implements Serializable {

    private static final long serialVersionUID = -5227748250193346675L;

    @JSONField(name = "dbFieldVoList")
    public List<DBFieldDto> dbFieldDtoList;

    public DBRecordDto() {}

    public DBRecordDto(List<DBFieldDto> dbFieldDtoList) {
        this.dbFieldDtoList = dbFieldDtoList;
    }

    public List<DBFieldDto> getDbFieldDtoList() {
        return dbFieldDtoList;
    }

    public void setDbFieldDtoList(List<DBFieldDto> dbFieldDtoList) {
        this.dbFieldDtoList = dbFieldDtoList;
    }
}
