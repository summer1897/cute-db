package com.zju.hpec.dao.impl;

import com.google.common.collect.Lists;
import com.zju.hpec.domain.DBField;
import com.zju.hpec.domain.DBRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Author summer
 * Date 2016/7/12
 * Time 20:56
 *
 * 该类实现了 @{link org.springframework.jdbc.core.RowMapper}接口
 * 主要用于将SQL查询结果封装为@{link DBRecord}实体对象
 */
public class RowMapperDBRecord implements RowMapper<DBRecord> {

    public DBRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<DBField> fields = Lists.newArrayList();
        ResultSetMetaData metaData = rs.getMetaData();
        for(int i = 1; i <= metaData.getColumnCount(); ++i){
            DBField field = new DBField(metaData.getColumnLabel(i),rs.getObject(i));
            fields.add(field);
        }
        return new DBRecord(fields);
    }
}
