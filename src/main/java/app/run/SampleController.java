package app.run;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgh.springboot.control.UserController;

@Controller
@EnableAutoConfiguration
// Controller扫描
@ComponentScan(basePackages = "com.zgh.springboot")
// Mybatis配置扫描
@MapperScan("com.zgh.springboot.dao")
// 原生Servlet,Filter,Listener扫描
@ServletComponentScan("com.zgh.springboot")
public class SampleController {
	private static Logger logger = Logger.getLogger(UserController.class);

	static String port;

	@Value("${server.port}")
	public void setPort(String port) {
		SampleController.port = port;
	}

	/**
	 * @description: 配置欢迎界面
	 * @author FreeGuardian
	 * @return
	 */
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "<center><font size=7 color=green> Hello World!" + port + "</fonts><center>";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(new Object[] { SampleController.class }, args);
		logger.debug("Open URL - http://localhost:" + port + " to access your application");
	}

}