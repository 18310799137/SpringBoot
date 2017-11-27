package com.zgh.springboot.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zgh.springboot.control.UserController;

public class LastInterceptor implements HandlerInterceptor {
	private static Logger logger = Logger.getLogger(UserController.class);

	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		logger.debug("LastInterceptor afterCompletion run ");

	}

	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		logger.debug("LastInterceptor postHandle run ");


	}

	
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		logger.debug("LastInterceptor preHandle run ");
		return true;
	}

}
