package com.zgh.springboot.config;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
	 * @description: 欢迎界面
	 * @author FreeGuardian
	 * @return
	 */
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "<center><h1>Hello World!</h1><center>";
	}
}
