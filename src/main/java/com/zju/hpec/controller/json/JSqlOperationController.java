package com.zju.hpec.controller.json;

import com.alibaba.fastjson.JSON;
import com.base.pagination.PaginationQuery;
import com.base.pagination.PaginationResult;
import com.google.common.collect.Maps;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.PropertyExtractUtils;
import com.summer.base.utils.StringUtils;
import com.zju.hpec.controller.view.ResponseView;
import com.zju.hpec.controller.vo.DBRecordVo;
import com.zju.hpec.service.ISqlOperationService;
import com.zju.hpec.service.dto.DBFieldDto;
import com.zju.hpec.service.dto.DBRecordDto;
import com.zju.hpec.utils.SqlUtils;
import com.zju.hpec.utils.TableResolveUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/13
 * Time: 15:43
 */
@Controller
public class JSqlOperationController {

    private Logger LOG = LoggerFactory.getLogger(JSqlOperationController.class);

    @Autowired
    private ISqlOperationService sqlOperationService;

    @RequestMapping(value = "/json/sql/query/result.json",method = RequestMethod.GET)
    @ResponseBody
    public ResponseView sqlQuery(@RequestParam String sql,
                                 @RequestParam(required = false,defaultValue = "1") int pageIndex,
                                 @RequestParam(required = false,defaultValue = "10") int pageSize){
        ResponseView responseView = new ResponseView();
        try{

            /*Map<String,Object> result = Maps.newHashMap();

            PaginationQuery paginationQuery = new PaginationQuery(pageIndex,pageSize);
            PaginationResult<DBRecordDto> dbRecordDtoPaginationResult = sqlOperationService.sqlQuery(sql,paginationQuery);
            List<DBRecordDto> dbRecordDtoList = dbRecordDtoPaginationResult.getResult();
//            System.out.println(JSON.toJSONString(dbRecordDtoList,true));

            PaginationResult<DBRecordVo> dbRecordVoPaginationResult = new PaginationResult<DBRecordVo>();
            dbRecordVoPaginationResult.setQuery(dbRecordDtoPaginationResult.getQuery());
            if(CollectionUtils.isNotEmpty(dbRecordDtoList)){
                List<DBFieldDto> dbFieldDtoList = dbRecordDtoList.get(0).getDbFieldDtoList();
                List<String> fieldNames = PropertyExtractUtils.extractPropertyFromDomain(dbFieldDtoList,"fieldName",String.class);
//                System.out.println("DBRecordDto size: "+dbRecordDtoList.size());
                List<DBRecordVo> dbRecordVoList = BeanCloneUtils.deepClone(dbRecordDtoList,DBRecordDto.class,DBRecordVo.class);
//                System.out.println("convert to DBRecordVo-------------------------");
                System.out.println(JSON.toJSONString(dbRecordVoList,true));
                dbRecordVoPaginationResult.setResult(dbRecordVoList);

                if(CollectionUtils.isNotEmpty(fieldNames)){
                    result.put("fieldNames",fieldNames);
                    result.put("dbRecords",dbRecordVoPaginationResult);
                    result.put("tableNames",TableResolveUtils.getTableNamesFromSqlAsList(sql));
                }
            }*/

//            responseView.setResult(result);
        }catch (Exception e){
            responseView.setCode(ResponseView.EXCEPTION_TOAST_SHOW);
            responseView.setMessage("SQL语句查询出错!");
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return responseView;
    }

    @RequestMapping(value = "/json/sql/query/orderedResult.json",method = RequestMethod.GET)
    @ResponseBody
    public ResponseView sqlOrder(@RequestParam String sql,
                                 @RequestParam String field,
                                 @RequestParam(required = false,defaultValue = "ASC") String order,
                                 @RequestParam(required = false,defaultValue = "1") int pageIndex,
                                 @RequestParam(required = false,defaultValue = "10") int pageSize){
        ResponseView responseView = new ResponseView();
        try {
            System.out.println("sql: "+sql);
            StringBuilder orderProperty = new StringBuilder(field);
            if(StringUtils.isNotEmpty(order)){
                orderProperty.append(" ").append(order);
            }

            PaginationQuery paginationQuery = new PaginationQuery(pageIndex,pageSize);
            paginationQuery.setSortedPropertyName(orderProperty.toString());

            PaginationResult<DBRecordDto> dbRecordDtoPaginationResult = sqlOperationService.sqlQuery(sql,paginationQuery);
            List<DBRecordDto> dbRecordDtoList = dbRecordDtoPaginationResult.getResult();

            PaginationResult<DBRecordVo> dbRecordVoPaginationResult = new PaginationResult<DBRecordVo>();
            dbRecordVoPaginationResult.setQuery(dbRecordDtoPaginationResult.getQuery());
            if(CollectionUtils.isNotEmpty(dbRecordDtoList)){
                List<DBRecordVo> dbRecordVoList = BeanCloneUtils.deepClone(dbRecordDtoList,DBRecordDto.class,DBRecordVo.class);
                dbRecordVoPaginationResult.setResult(dbRecordVoList);
            }
            responseView.setResult(dbRecordVoPaginationResult);
            System.out.println(JSON.toJSONString(responseView,true));
        } catch (Exception e) {
            responseView.setCode(ResponseView.EXCEPTION_TOAST_SHOW);
            responseView.setMessage("SQL语句查询出错!");
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return responseView;
    }
}
