package com.zgh.springboot.control;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgh.springboot.dao.UserMapper;
import com.zgh.springboot.entity.User;

/**
 *  
 */
@Controller
@RequestMapping("/mvcRest")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserMapper userMapper;

	@RequestMapping(value = "/queryUser")
	@ResponseBody
	public User queryUser() {
		logger.debug("RequestMapping : [ mvcRest/queryUser ]  run");
		User user = userMapper.findUserByName("zhangsan");
		return user;
		//打开浏览器访问 http://localhost:9001/mvcRest/queryUser 返回格式为: {"id":1,"name":"zhangsan","age":30}
	}
}
