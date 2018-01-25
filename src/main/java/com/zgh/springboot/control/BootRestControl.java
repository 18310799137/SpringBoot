package com.zgh.springboot.control;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zgh.springboot.dao.UserMapper;
import com.zgh.springboot.entity.User;

@RestController()
@RequestMapping("/bootRest")
public class BootRestControl {

	private static Logger logger = Logger.getLogger(BootRestControl.class);
	@Autowired
	UserMapper userMapper;

	@RequestMapping(value = "/queryUser")
	public User queryUser() {
		logger.debug("RequestMapping : [ bootRest/queryUser ]  run");
		User user = userMapper.findUserByName("zhangsan");
		return user;
		//浏览器访问 http://localhost:9001/bootRest/queryUser 返回格式为:	{"id":1,"name":"zhangsan","age":30}    @RestController 相当于Springmvc @Controller + @ResponseBody
	}
}
