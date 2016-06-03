package com.zju.hpec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @Description: 该Controller用于视图名到视图资源的直接映射
 * @author hzduao
 * @Date 2016年5月24日
 *
 */
@Controller
public class PageDispatcherController {

	@RequestMapping("/{viewName}")
	public String dispatcher(@PathVariable String viewName){
		return viewName;
	}
	
	@RequestMapping("/common/{viewName}")
	public String commonDispatcher(@PathVariable String viewName){
		return "common/"+viewName;
	}
}
