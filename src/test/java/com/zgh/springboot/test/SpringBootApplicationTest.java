package com.zgh.springboot.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class SpringBootApplicationTest {
	/**
	 * @description:接口调用
	 * @author FreeGuardian
	 * @param args
	 */
	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target("http://localhost:9001/").path("bootRest/queryUser");

		Response retn = webTarget.request().get();

		int retnStatus = retn.getStatus();

		String retnCode = retn.readEntity(String.class).toString();

		System.out.println("retnStatus:" + retnStatus);

		System.out.println("retnCode:" + retnCode);
	}
}
