package com.zgh.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.zgh.springboot.control.BootRestControl;

/**
 * @description: Listener 第一种配置方式,在类中添加WebListener注解,启动boot类时,需配置扫描本类所在的包
 * 
 * @author FreeGuardian
 *
 */
@WebListener
public class BootServletListener implements ServletContextListener {
	private static Logger logger = Logger.getLogger(BootRestControl.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.debug("BootServletListener ContextInitialized:" + sce.getServletContext().getServerInfo());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.debug("BootServletListener ContextDestroyed:" + sce.getServletContext().getServerInfo());
	}

}
