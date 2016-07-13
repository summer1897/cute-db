package com.zju.hpec.dao.impl;

import com.base.pagination.PaginationQuery;
import com.base.pagination.PaginationResult;
import com.zju.hpec.dao.ISqlQueryDao;
import com.zju.hpec.domain.DBRecord;
import com.zju.hpec.utils.DBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Author summer
 * Date 2016/7/12
 * Time 20:26
 */
@Repository
public class SqlQueryDaoImpl implements ISqlQueryDao {

    private static final Logger LOG = LoggerFactory.getLogger(SqlQueryDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long queryCount(String sql) {
        return jdbcTemplate.queryForObject(sql,Long.class);
    }

    public List<DBRecord> sqlQuery(final String sql) {
       return jdbcTemplate.query(sql, new RowMapperDBRecord());
    }

    public PaginationResult<DBRecord> sqlQuery(String sql, PaginationQuery paginationQuery) {
        StringBuilder condition = new StringBuilder(sql);
        DBUtils.appendPaginationCondition(condition,paginationQuery);
        PaginationResult<DBRecord> dbRecordPaginationResult = new PaginationResult<DBRecord>(paginationQuery);
        dbRecordPaginationResult.setResult(jdbcTemplate.query(condition.toString(), new RowMapperDBRecord()));
        return dbRecordPaginationResult;
    }
}
