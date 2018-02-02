package com.zgh.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.zgh.springboot.control.BootRestControl;

@WebFilter(filterName = "bootFilter", urlPatterns = { "/filter/*", "/bootFilter/*" })
public class BootFilter implements Filter {
	private static Logger logger = Logger.getLogger(BootRestControl.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("BootFilter Init method " + filterConfig.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String reqestUrl = ((HttpServletRequest) request).getRequestURL().toString();
		logger.info("BootFilter doFilter run - " + reqestUrl);
		response.getOutputStream().print("access denied [" + reqestUrl + "]");
	}

	@Override
	public void destroy() {
		logger.info("BootFilter destroy  ");

	}

}
