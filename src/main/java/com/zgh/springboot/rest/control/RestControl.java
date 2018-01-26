package com.zgh.springboot.rest.control;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
		// 浏览器访问 http://localhost:9001/rest/getUserInfo 返回{"id":5,"name":"风清扬","age":10}
		// 通过浏览器 访问 http://localhost:9001/rest/application.wadl 可以查看rest接口详细信息

		return user;
	}

	/**
	 * @description:客户端传递json到服务端 封装为对象
	 * @author FreeGuardian
	 * @param user
	 * @return
	 */
	@POST
	@Path("/saveUserInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveUserInfo(User user) {
		logger.debug("RequestMapping : [ rest/saveUserInfo ]  run");
		String result = "server receive code : " + user;
		return Response.status(200).entity(result).build();
	}

	/**
	 * @description:使用路径直接作为参数使用,访问 http://localhost:9001/rest/path/*
	 *                              都将访问本方法,并且*将作为userId的值传递给方法
	 * @author FreeGuardian
	 * @param userId
	 * @return
	 */
	@POST
	@Path("/path/{id}")
	public String pathParam(@PathParam("id") String userId) {
		logger.debug("RequestMapping : [ rest/path/{id} ]  run");

		return "Server recieve param userId : " + userId;
	}

}
