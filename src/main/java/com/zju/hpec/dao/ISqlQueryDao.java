package com.zju.hpec.dao;

import com.base.pagination.PaginationQuery;
import com.base.pagination.PaginationResult;
import com.zju.hpec.domain.DBRecord;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Author summer
 * Date 2016/7/12
 * Time 20:16
 */
public interface ISqlQueryDao {

    /**
     * 查询记录数
     * @param sql SQL语句
     * @return
     */
    long queryCount(String sql);

    /**
     * 执行SQL查询语句，并返回查询结果
     * @param sql SQL语句
     * @return @{link DBRecord}
     */
    List<DBRecord> sqlQuery(String sql);

    /**
     * 执行SQL查询语句，并分页返回SQL查询结果
     * @param sql SQL语句
     * @param paginationQuery
     * @return @{link DBRecord}
     */
    PaginationResult<DBRecord> sqlQuery(String sql, PaginationQuery paginationQuery);
}
