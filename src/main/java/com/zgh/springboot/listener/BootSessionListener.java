package com.zgh.springboot.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.zgh.springboot.control.BootRestControl;

public class BootSessionListener implements HttpSessionListener {
	private static Logger logger = Logger.getLogger(BootRestControl.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.debug("SessionCreated:" + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.debug("SessionCreated:" + se.getSession().getId());
	}

}
