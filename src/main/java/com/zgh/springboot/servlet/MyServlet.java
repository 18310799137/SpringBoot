package com.zgh.springboot.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zgh.springboot.control.BootRestControl;

public class MyServlet extends HttpServlet {
	/**
	 * 配置中心注册方式不需要在此类进行注解@WebServlet,查看BootConfig类
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(BootRestControl.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("MyServlet init " + config.getServletContext().getContextPath());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("MyServlet doGet run " + req.getRequestURL());
		resp.getOutputStream()
				.print("<font size='5' color='green' >MYSERVLET RETURN CODE	ACCESS URL [" + req.getRequestURL() + "]   SUCCESS </font>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("MyServlet doPost run" + req.getRequestURL());
	}

}
