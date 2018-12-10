package com.cskaoyan.interceptor;

import com.cskaoyan.controller.FormController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 判断用户权限的Spring MVC的拦截器
 */
public class AuthorizedInterceptor implements HandlerInterceptor {

	/** 定义不需要拦截的请求 */
	private static final String[] IGNORE_URI = {"/loginForm", "/login","/404.html"};

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		httpServletRequest.setCharacterEncoding("utf-8");
		httpServletResponse.setContentType("text/html;charset=utf-8");

		String requestURI = httpServletRequest.getRequestURI();
		System.out.println(requestURI);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}

	/**
     * 该方法需要preHandle方法的返回值为true时才会执行。
     * 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
     */  

	 /** 
     * 这个方法在preHandle方法返回值为true的时候才会执行。
     * 执行时间是在处理器进行处理之 后，也就是在Controller的方法调用之后执行。
     */  


	 /** 
     * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，
     * 当preHandle的返回值为false的时候整个请求就结束了。 
     * 如果preHandle的返回值为true，则会继续执行postHandle和afterCompletion。
     */  


}
