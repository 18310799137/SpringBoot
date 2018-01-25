package com.zgh.springboot.rest.control;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.zgh.springboot.control.BootRestControl;
import com.zgh.springboot.entity.User;

@Path("/")
public class RestControl {
	private static Logger logger = Logger.getLogger(BootRestControl.class);

	@GET
	@Path("/getUserInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserInfo() {
		logger.debug("RequestMapping : [ rest/getUserInfo ]  run");
		User user = new User();
		user.setAge(10);
		user.setId(5);
		user.setName("风清扬");
		//浏览器访问 http://localhost:9001/rest/getUserInfo  返回{"id":5,"name":"风清扬","age":10}
		//通过浏览器 访问 http://localhost:9001/rest/application.wadl 可以查看rest接口详细信息
	
		return user;
	}

	@GET
	@Path("/saveUserInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveUserInfo(User user) {
		String result = "User saved : " + user;
		return Response.status(201).entity(result).build();
	}

}
