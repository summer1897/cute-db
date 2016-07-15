package com.zju.hpec.controller.html;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zju.hpec.domain.DBRecord;
import com.zju.hpec.service.IDBTableService;

@Controller
public class HTableController {

	private static final Logger LOG = LoggerFactory.getLogger(HTableController.class);

	@Autowired
	private IDBTableService dbTableService;
	
	@RequestMapping("/common/right.html")
	public String dbRecords(@RequestParam String tableName,Model model){
		String returnPath = "common/right";

		if(null == tableName || "".equals(tableName))
			return returnPath;
		
		List<DBRecord> records = dbTableService.getAllRecords(tableName);
		model.addAttribute("records", records);
		model.addAttribute("tableName",tableName);
		return returnPath;
	}
}
