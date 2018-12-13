package com.cskaoyan.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {



    /**
     * 处理shiro ajax请求
     */
    @RequestMapping(value = "/ajaxLogin")
    @ResponseBody
    public Map<String, Object> ajaxLogin(@RequestParam String username,
                                         @RequestParam String password,
                                         @RequestParam(required = false) String randomcode,
                                         HttpSession session){

        Map<String, Object> map = new HashMap<>();

        //可以在这里添加验证码功能

        //这里取出的是什么东西？
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try{
                currentUser.login(token);

            }catch(UnknownAccountException ex){
                map.put("msg", "account_error");
            }catch(IncorrectCredentialsException ex){
                map.put("msg", "password_error");
            }catch(AuthenticationException ex){
                map.put("msg", "authentication_error");
            }
        }

        //返回json数据
        return map;

    }


    /*
    //可以在applicationContext.xml中配置注销过滤器
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    */


}
