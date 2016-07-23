package com.zju.hpec.controller.html;

import java.util.List;

import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.PropertyExtractUtils;
import com.zju.hpec.controller.vo.DBRecordVo;
import com.zju.hpec.service.dto.DBFieldDto;
import com.zju.hpec.service.dto.DBRecordDto;
import com.zju.hpec.utils.SqlUtils;
import org.apache.commons.collections.CollectionUtils;
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
		
		List<DBRecordDto> dbRecordDtoList = dbTableService.getAllRecords(tableName);

		if(CollectionUtils.isNotEmpty(dbRecordDtoList)){
			List<DBFieldDto> dbFieldDtoList = dbRecordDtoList.get(0).getDbFieldDtoList();
			//获取数据库字段名
			List<String> dbFieldNames = PropertyExtractUtils.extractPropertyFromDomain(dbFieldDtoList,"fieldName",String.class);
			List<DBRecordVo> dbRecordVoList = BeanCloneUtils.deepClone(dbRecordDtoList,DBRecordDto.class,DBRecordVo.class);

			model.addAttribute("dbFieldNames",dbFieldNames);
			model.addAttribute("records", dbRecordVoList);
		}
		model.addAttribute("tableName",tableName);
//		model.addAttribute("sql", SqlUtils.convertAllSpaceInSql("select *from "+tableName));
		model.addAttribute("sql", "select *from "+tableName);
		return returnPath;
	}
}
