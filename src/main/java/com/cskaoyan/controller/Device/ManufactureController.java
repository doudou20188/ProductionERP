package com.cskaoyan.controller.Device;

import com.cskaoyan.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 生产计划管理控制器
 * @Auther: YangTao
 * @Date: 2018/12/7 0007
 */
@Controller
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("manufacture/find")
    public String ManufactureFind(){

        return "manufacture_list";
    }

    @ResponseBody
    @RequestMapping("manufacture/list")
    public Map AjaxList(String rows, String Page){
        HashMap hashMap = new HashMap();


        return hashMap;

    }





}
