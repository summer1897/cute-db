package com.zju.hpec.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zju.hpec.admin.domain.DBSource;
import com.zju.hpec.admin.service.IDBSourceService;

/**
 *
 * @Description: admin controller
 * @author hzduhao
 * @Date 2016年5月28日
 *
 */
@Controller
public class AdminController {
	
	@Autowired
	private IDBSourceService dbSourceSerivce;

	@RequestMapping("/admin/{viewName}")
	public String dispatcher(@PathVariable String viewName){
		return "admin/"+viewName;
	}
	
	@RequestMapping("/admin/dbsource/{viewName}")
	public String dbsourceDispatcher(@PathVariable String viewName){
		return "admin/"+viewName;
	}
	
	@RequestMapping("/admin.html")
	public String admin(HttpServletRequest request){
		return "admin/admin";
	}
	
	/**
	 * 基本设置
	 * @return
	 */
	@RequestMapping("/admin/settings.html")
	public String basicSettings(){
		return "admin/basic-settings";
	}
	
	/**
	 * 展示所有数据源信息
	 * @return
	 */
	@RequestMapping("/admin/dbsource.html")
	public String showAllDbSource(){
		return "admin/datasource";
	}
	
	/**
	 * 数据源设置
	 * @return
	 */
	@RequestMapping("/admin/dbsource/settings.html")
	public String dbSourceSettings(){
		return "admin/dbsource-settings";
	}
	
	/**
	 * 添加数据源
	 * @param dbSource
	 * @return
	 */
	@RequestMapping("/admin/dbsource/addHandler.html")
	public String addDBSource(DBSource dbSource){
//		System.out.println(dbSource.getDbType());
		return "admin/add";
	}
	
	@RequestMapping("/admin/dbsource/canConnect.html")
	@ResponseBody
	public Map<String,Object> canConnect(DBSource dbSource,HttpServletResponse response){
		Map<String,Object> result = new HashMap<String,Object>();
//		System.out.println("dbName: "+dbSource.getDbName());
		boolean flag = dbSourceSerivce.canConnection(dbSource);
		if(flag)
			System.out.println("连接成功!");
		else
			System.out.println("连接失败!");
			result.put("canConnect", dbSourceSerivce.canConnection(dbSource));
			return result;
//			response.getOutputStream().write(result.toString().getBytes("UTF-8"));
	}
}
