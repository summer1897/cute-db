package com.zju.hpec.service.impl;

import com.base.pagination.PaginationQuery;
import com.base.pagination.PaginationResult;
import com.google.common.collect.Lists;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.StringUtils;
import com.zju.hpec.dao.ISqlOperationDao;
import com.zju.hpec.domain.DBRecord;
import com.zju.hpec.service.ISqlOperationService;
import com.zju.hpec.service.dto.DBRecordDto;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/13
 * Time: 15:30
 */
@Service
public class SqlOperationServiceImpl implements ISqlOperationService {

    private Logger LOG = LoggerFactory.getLogger(SqlOperationServiceImpl.class);

    @Autowired
    private ISqlOperationDao sqlQueryDao;

    /**
     * 查询记录数
     *
     * @param sql SQL语句
     * @return long
     */
    public long queryCount(String sql) {
        return sqlQueryDao.queryCount(sql);
    }

    /**
     * 执行SQL查询语句，并返回查询结果
     *
     * @param sql SQL语句
     * @return @{link DBRecordVo}
     */
    public List<DBRecordDto> sqlQuery(String sql) {

        List<DBRecordDto> dbRecordDtoList = Lists.newArrayList();

        if(StringUtils.isEmpty(sql)){
            return dbRecordDtoList;
        }

        List<DBRecord> dbRecordList = sqlQueryDao.sqlQuery(sql);

        if(CollectionUtils.isNotEmpty(dbRecordList)){
            dbRecordDtoList.addAll(BeanCloneUtils.deepClone(dbRecordList,DBRecord.class,DBRecordDto.class));
        }
        return dbRecordDtoList;
    }

    /**
     * 执行SQL查询语句，并分页返回SQL查询结果
     *
     * @param sql  SQL语句
     * @param paginationQuery
     * @return @{link DBRecordVo}
     */
    public PaginationResult<DBRecordDto> sqlQuery(String sql, PaginationQuery paginationQuery) {
        PaginationResult<DBRecordDto> dbRecordDtoPaginationResult = new PaginationResult<DBRecordDto>();

        if(StringUtils.isEmpty(sql)){
            return dbRecordDtoPaginationResult;
        }

        PaginationResult<DBRecord> dbRecordPaginationResult = sqlQueryDao.sqlQuery(sql,paginationQuery);
        List<DBRecord> dbRecordList = dbRecordPaginationResult.getResult();
        dbRecordDtoPaginationResult.setQuery(dbRecordPaginationResult.getQuery());

        if(CollectionUtils.isNotEmpty(dbRecordList)){
            dbRecordDtoPaginationResult.setResult(BeanCloneUtils.deepClone(dbRecordList,DBRecord.class,DBRecordDto.class));
        }

        return dbRecordDtoPaginationResult;
    }
}
