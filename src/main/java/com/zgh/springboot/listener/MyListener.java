/**
 * 
 */
package com.zgh.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.zgh.springboot.control.BootRestControl;

/**
 * @description: Listener 第二种配置方式,在Bean注解的配置中注册,本示例在 BootConfig 类中注册,无需配置扫描的包
 * @author FreeGuardian
 */
public class MyListener implements ServletContextListener {
	private static Logger logger = Logger.getLogger(BootRestControl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.debug("MyListener ContextInitialized:" + sce.getServletContext().getServerInfo());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.debug("MyListener ContextDestroyed:" + sce.getServletContext().getServerInfo());
	}

}
