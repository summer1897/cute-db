package com.zju.hpec.service;

import com.base.pagination.PaginationQuery;
import com.base.pagination.PaginationResult;
import com.zju.hpec.service.dto.DBRecordDto;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/13
 * Time: 11:42
 */
public interface ISqlOperationService {

    /**
     * 查询记录数
     * @param sql SQL语句
     * @return
     */
    long queryCount(String sql);

    /**
     * 执行SQL查询语句，并返回查询结果
     * @param sql SQL语句
     * @return @{link DBRecordVo}
     */
    List<DBRecordDto> sqlQuery(String sql);

    /**
     * 执行SQL查询语句，并分页返回SQL查询结果
     * @param sql SQL语句
     * @param paginationQuery
     * @return @{link DBRecordVo}
     */
    PaginationResult<DBRecordDto> sqlQuery(String sql, PaginationQuery paginationQuery);
}
