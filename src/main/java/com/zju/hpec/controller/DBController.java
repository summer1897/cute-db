package com.zju.hpec.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.zju.hpec.utils.DBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zju.hpec.domain.DBRecord;
import com.zju.hpec.service.IDBTableService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class DBController {

	@Autowired
	private IDBTableService dbTableService;
	
	@RequestMapping(value={"/","/index","index.html","index.htm"})
	public String index(Model model){
		List<String> tables = dbTableService.getTables();
		model.addAttribute("tables", tables);
		return "index";
	}
	
	@RequestMapping("common/left.html")
	public String dbCatalog(Model model){

		return "common/left";
	}
	
	@RequestMapping("/common/right.html")
	public String dbRecords(@RequestParam String tableName,Model model){
		String returnPath = "common/right";

//		System.out.println("returnPath: "+returnPath);

		if(null == tableName || "".equals(tableName))
			return returnPath;
		
		List<DBRecord> records = dbTableService.getAllRecords(tableName);
		model.addAttribute("records", records);
		model.addAttribute("tableName",tableName);
		return returnPath;
	}

	@RequestMapping(value = "/common/queryTablesMatchesName.html",method = RequestMethod.GET)
	public void queryTablesMatchesName(@RequestParam String tableName,
									   HttpServletResponse response){
		List<String> tables = null;
		System.out.println("tableName: "+tableName);
		try {
			if(null == tableName || "".equals(tableName)) {
				tables = dbTableService.getTables();
			}else {
				tables = dbTableService.queryTablesMatchesName("%" + tableName + "%");
			}
			response.getOutputStream().write(JSON.toJSONString(tables).getBytes(DBUtils.DEFAULT_CHARSET));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/common/showCreateTable.html",method = RequestMethod.GET)
	public void showCreateTable(@RequestParam String tableName,
								HttpServletResponse response){
		String tableInfo = "";
		try{
//			System.out.println("tableName: "+tableName);
			tableInfo = dbTableService.getTableCreateInfo(tableName);
//			tableInfo.replace("\n","<br/>");
			String[] infos = tableInfo.split("\n");
			for(String info : infos)
				System.out.println(info);
			//System.out.println(tableInfo.replace("\n","$$"));
			List<String> tableInfos = Arrays.asList(infos);
			response.getOutputStream().write(JSON.toJSONString(tableInfos).getBytes(DBUtils.DEFAULT_CHARSET));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
