package com.zgh.springboot.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class QuartzJob2 {
	
	private static Logger logger = Logger.getLogger(QuartzJob2.class);
	/*
		表达式  								意义
	"0 0 12 * * ?"	 				每天中午12点触发
	"0 15 10 ? * *"	 				每天上午10:15触发
	"0 15 10 * * ?"	 				每天上午10:15触发
	"0 15 10 * * ? *"	 			每天上午10:15触发
	"0 15 10 * * ? 2005"			2005年的每天上午10:15触发
	"0 * 14 * * ?"	 				在每天下午2点到下午2:59期间的每1分钟触发
	"0 0/5 14 * * ?"	 			在每天下午2点到下午2:55期间的每5分钟触发
	"0 0/5 14,18 * * ?"	 			在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
	"0 0-5 14 * * ?"	 			在每天下午2点到下午2:05期间的每1分钟触发
	"0 10,44 14 ? 3 WED"			每年三月的星期三的下午2:10和2:44触发
	"0 15 10 ? * MON-FRI"			周一至周五的上午10:15触发
	"0 15 10 15 * ?"	 			每月15日上午10:15触发
	"0 15 10 L * ?"	 				每月最后一日的上午10:15触发
	"0 15 10 ? * 6L"	 			每月的最后一个星期五上午10:15触发 
	"0 15 10 ? * 6L 2002-2005"	 	2002年至2005年的每月的最后一个星期五上午10:15触发
	"0 15 10 ? * 6#3"	 			每月的第三个星期五上午10:15触发
	*/
		/**
		 * Every eight seconds  Execute This Method
		 * @throws InterruptedException 
		 */
/*	   @Scheduled(fixedRate = 8000)
	    public void reportJob() throws InterruptedException{
		   
		   logger.debug("[fixedRate Job Execute]"+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
	    }
		*/
	   
	   /**
	 * @throws InterruptedException
		 * 
		 */
	    @Scheduled(cron = "0/5 * * ? * *")
	    public void cronJob() throws InterruptedException {
	    	logger.debug("[Cron Job Execute]"+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
		}
}
