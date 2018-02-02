package com.zgh.springboot.config;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zgh.springboot.filter.MyFilter;
import com.zgh.springboot.listener.MyListener;
import com.zgh.springboot.servlet.MyServlet;

// 在标记Configuration的注解中 可以做些初始化工作 ，生产Bean，初始化配置等
@Configuration
public class BootConfig {
	/**
	 * 集成Rest jersey或者直接使用SpringBoot rest风格,类上标记 @RestController注解即可
	 * 
	 * @author FreeGuardian
	 * @return
	 */
	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
		registration.addInitParameter("jersey.config.server.provider.packages", "com.zgh.springboot.rest.control");
		return registration;
	}

	/**
	 * 底下的这三个方法 Filter,Servlet,Listener,注册时不需要在类上标记注解,但需要在此配置(以My开头的几个servlet 以及
	 * listner类)。还有一种方式可以不在这里配置,需要在类上标记注解,启动类上也需要配置扫描的包路径(以Boot开头的Listner,Servlet,Filter)
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean regMyFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();

		MyFilter myFilter = new MyFilter();
		registrationBean.setFilter(myFilter);
		List<String> urlPatterns = new ArrayList<String>();
		// 拦截路径，可以添加多个
		urlPatterns.add("/myFilter/*");
		urlPatterns.add("/myBootFilter/*");
		registrationBean.setUrlPatterns(urlPatterns);
		registrationBean.setOrder(1);
		return registrationBean;
	}

	@Bean
	public ServletRegistrationBean regMyServlet() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet/*",
				"/myBootServlet/*");
		registrationBean.setLoadOnStartup(1);
		return registrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<EventListener> regMyListener() {
		ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<>(
				new MyListener());
		return registrationBean;
	}
}
