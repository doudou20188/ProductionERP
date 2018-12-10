package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Description:  
 * @date 2015年8月13日 下午8:30:37 
 * @version V1.0   
 */

/**
 * 动态页面跳转控制器
 * */
@Controller
public class FormController {

	@RequestMapping(value="/{formName}")
	 public String loginForm(@PathVariable String formName){
		// 动态跳转页面，处理jsp跳转
		System.out.println(formName);
		return  formName;
		//return "/WEB-INF/jsp/"+formName+".jsp";

	}



}

