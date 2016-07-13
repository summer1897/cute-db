package com.zju.hpec.controller.html;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zju.hpec.domain.DBRecord;
import com.zju.hpec.service.IDBTableService;

@Controller
public class HTableController {

	@Autowired
	private IDBTableService dbTableService;
	
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
}
