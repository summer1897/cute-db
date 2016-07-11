package com.zju.hpec.controller.json;

import com.zju.hpec.service.IDBTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Created by summer on 2016/7/11.
 */
@Controller
public class JTableController {

    private static final Logger LOG = LoggerFactory.getLogger(JTableController.class);

    @Autowired
    private IDBTableService dbTableService;

    @RequestMapping(value = "/json/common/queryTablesMatchesName.json",method = RequestMethod.GET)
    @ResponseBody
    public List<String> queryTablesMatchesName(@RequestParam String tableName){
        List<String> tables = null;
//        System.out.println("tableName: "+tableName);
        try {
            if(null == tableName || "".equals(tableName)) {
                tables = dbTableService.getTables();
            }else {
                tables = dbTableService.queryTablesMatchesName("%" + tableName + "%");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return tables;
    }

    @RequestMapping(value = "/json/common/showCreateTable.json",method = RequestMethod.GET)
    @ResponseBody
    public List<String> showCreateTable(@RequestParam String tableName){
        List<String> tableInfos = null;
        try{
//			System.out.println("tableName: "+tableName);
            String tableInfo = dbTableService.getTableCreateInfo(tableName);
            String[] infos = tableInfo.split("\n");

            for(String info : infos)
                System.out.println(info);

            tableInfos = Arrays.asList(infos);
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return tableInfos;
    }
}
