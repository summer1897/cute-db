package com.zju.hpec.controller.html;

import com.zju.hpec.service.IDBTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by summer on 2016/7/11.
 */
@Controller
public class HMainFrameController {

    private static final Logger LOG = LoggerFactory.getLogger(HMainFrameController.class);

    @Autowired
    private IDBTableService dbTableService;

    @RequestMapping(value={"/","/index","index.html","index.htm"})
    public String index(Model model){
        List<String> tables = dbTableService.getTables();
        model.addAttribute("tables", tables);
        return "index";
    }

    @RequestMapping("/common/left.html")
    public String dbCatalog(Model model){

        return "common/left";
    }
}
