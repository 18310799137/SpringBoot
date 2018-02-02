package com.zgh.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class MultiThreadJobConfig {

	/**
	 * @description: 配置定时任务进行并行执行,需要初始化任务线程池,如不配置此Bean,定时任务将单线程执行,如需要并行执行时 只能阻塞.
	 * @author FreeGuardian
	 * @return
	 */
	@Bean
	public TaskScheduler scheduledTaskConfig() {
		ThreadPoolTaskScheduler poolTaskScheduler = new ThreadPoolTaskScheduler();
		// 根据任务的多少去配置,建议一个任务配置一个,若执行间隔短,出现阻塞情况,那么当前阻塞任务处于等待状态,等待上个任务执行完毕,其余任务并行执行.
		poolTaskScheduler.setPoolSize(5);

		poolTaskScheduler.setBeanName("ThreadTask-Boot-Job");
		poolTaskScheduler.initialize();
		return poolTaskScheduler;

	}
}
