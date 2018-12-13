package com.cskaoyan.controller;


import com.cskaoyan.shiro.CustomRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShiroCacheController {

    @Autowired
    CustomRealm customRealm;

    @RequestMapping("/clear")
    public String clearCache(){
        customRealm.clearCached();
        return "login";
    }

}
