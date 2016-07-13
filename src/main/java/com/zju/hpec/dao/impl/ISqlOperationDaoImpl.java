package com.zju.hpec.dao.impl;

import com.base.pagination.PaginationQuery;
import com.base.pagination.PaginationResult;
import com.zju.hpec.dao.ISqlOperationDao;
import com.zju.hpec.domain.DBRecord;
import com.zju.hpec.utils.DBUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Author summer
 * Date 2016/7/12
 * Time 20:26
 */
@Repository
public class ISqlOperationDaoImpl implements ISqlOperationDao {

    private static final Logger LOG = LoggerFactory.getLogger(ISqlOperationDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long queryCount(String sql) {
        List<Map<String,Object>> result = jdbcTemplate.queryForList(sql);
        if(CollectionUtils.isNotEmpty(result)){
            return result.size();
        }
        return 0;
    }

    public List<DBRecord> sqlQuery(final String sql) {
       return jdbcTemplate.query(sql, new RowMapperDBRecord());
    }

    public PaginationResult<DBRecord> sqlQuery(String sql, PaginationQuery paginationQuery) {
//        System.out.println("sql: "+sql);
        long totalRecord = queryCount(sql);

//        System.out.println("total record: "+totalRecord);
        StringBuilder condition = null;
        PaginationResult<DBRecord> dbRecordPaginationResult = null;
        if (totalRecord > 0) {
            condition = new StringBuilder(sql);
            paginationQuery.setTotalRecords(totalRecord);
            DBUtils.appendPaginationCondition(condition,paginationQuery);
            System.out.println("query condition: "+condition.toString());
            dbRecordPaginationResult = new PaginationResult<DBRecord>(paginationQuery);
        }else{
            return dbRecordPaginationResult;
        }

        dbRecordPaginationResult.setResult(jdbcTemplate.query(condition.toString(), new RowMapperDBRecord()));
//        System.out.println("result: "+ JSON.toJSONString(dbRecordPaginationResult.getResult(),true));
        return dbRecordPaginationResult;
    }
}
