package com.cskaoyan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/6 10:36
 **/
@Controller
public class UserController {
    @RequestMapping("/login")
    public String handkerLogin(String name,String password){
        return "/index.jsp";
    }
}
