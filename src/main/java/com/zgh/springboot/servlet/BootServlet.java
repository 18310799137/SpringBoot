package com.zgh.springboot.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zgh.springboot.control.BootRestControl;

@WebServlet(urlPatterns = { "/servlet/*", "/bootServlet/*" }, loadOnStartup = 1, name = "bootServlet")
public class BootServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(BootRestControl.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("BootServlet init " + config.getServletContext().getContextPath());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("BootServlet doGet run " + req.getRequestURL());
		resp.getOutputStream().print("<font size='5' color='blue' >BOOTSERVLET RETURN CODE ACCESS URL ["
				+ req.getRequestURL() + "]   SUCCESS </font>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("BootServlet doPost run" + req.getRequestURL());
	}

}
