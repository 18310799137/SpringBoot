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
@RequestMapping({ "/user" })
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserMapper userMapper;

	@RequestMapping(value = "/queryUser")
	@ResponseBody
	public String queryUser() {
		logger.debug("RequestMapping : [ user/queryUser ]is run");
		User user = userMapper.findUserByName("zhangsan");
		return user.toString();
	}
}
