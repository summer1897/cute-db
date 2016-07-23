package com.zju.hpec.controller.html;

import com.base.pagination.PaginationQuery;
import com.base.pagination.PaginationResult;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.PropertyExtractUtils;
import com.zju.hpec.controller.vo.DBRecordVo;
import com.zju.hpec.service.ISqlOperationService;
import com.zju.hpec.service.dto.DBFieldDto;
import com.zju.hpec.service.dto.DBRecordDto;
import com.zju.hpec.utils.TableResolveUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 16/7/23 上午10:19
 * @Description
 */
@Controller
public class HSqlOperationController {

    private Logger LOG = LoggerFactory.getLogger(HSqlOperationController.class);

    @Autowired
    private ISqlOperationService sqlOperationService;

    @RequestMapping(value = "/html/sql/query/result.html",method = RequestMethod.GET)
    public String sqlQuery(@RequestParam String sql,
                           @RequestParam(required = false,defaultValue = "1") int pageIndex,
                           @RequestParam(required = false,defaultValue = "10") int pageSize,
                           Model model){
        String path = "sql/query-result";

        try {

            PaginationQuery paginationQuery = new PaginationQuery(pageIndex,pageSize);
            PaginationResult<DBRecordDto> dbRecordDtoPaginationResult = sqlOperationService.sqlQuery(sql,paginationQuery);
            List<DBRecordDto> dbRecordDtoList = dbRecordDtoPaginationResult.getResult();

            PaginationResult<DBRecordVo> dbRecordVoPaginationResult = new PaginationResult<DBRecordVo>();
            dbRecordVoPaginationResult.setQuery(dbRecordDtoPaginationResult.getQuery());
            if(CollectionUtils.isNotEmpty(dbRecordDtoList)){
                List<DBFieldDto> dbFieldDtoList = dbRecordDtoList.get(0).getDbFieldDtoList();
                List<String> fieldNames = PropertyExtractUtils.extractPropertyFromDomain(dbFieldDtoList,"fieldName",String.class);
                List<DBRecordVo> dbRecordVoList = BeanCloneUtils.deepClone(dbRecordDtoList,DBRecordDto.class,DBRecordVo.class);
//                System.out.println(JSON.toJSONString(dbRecordVoList,true));
                dbRecordVoPaginationResult.setResult(dbRecordVoList);

                if(CollectionUtils.isNotEmpty(fieldNames)){
                    model.addAttribute("fieldNames",fieldNames);
                    model.addAttribute("dbRecords",dbRecordVoPaginationResult);
                    model.addAttribute("tableNames",TableResolveUtils.getTableNamesFromSqlAsList(sql));
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return path;
    }

}
