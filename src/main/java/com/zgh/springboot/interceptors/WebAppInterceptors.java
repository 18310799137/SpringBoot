/**
 * 
 */
/**
 * @author FreeGuardian
 *
 */
package com.zgh.springboot.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppInterceptors extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new LastInterceptor()).addPathPatterns("/*");
		super.addInterceptors(registry);
	}
}