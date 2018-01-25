package app.run;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import com.zgh.springboot.control.UserController;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.zgh.springboot")
@MapperScan("com.zgh.springboot.dao")
public class SampleController {
	private static Logger logger = Logger.getLogger(UserController.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(new Object[] { SampleController.class }, args);
		logger.debug("Open URL - http://localhost:9001  to access your application");
	}

}