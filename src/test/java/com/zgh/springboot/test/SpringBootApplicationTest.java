package com.zgh.springboot.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

public class SpringBootApplicationTest {
	static Client client = ClientBuilder.newClient();

	/**
	 * @description:接口调用
	 * @author FreeGuardian
	 */
	public static void requestRest() {

		WebTarget webTarget = client.target("http://localhost:9001/").path("bootRest/queryUser");

		Response response = webTarget.request().get();

		int retnStatus = response.getStatus();

		String retnCode = response.readEntity(String.class).toString();

		System.out.println("retnStatus:" + retnStatus);

		System.out.println("retnCode:" + retnCode);
	}

	public static void postParamToRestService() {
		WebTarget webTarget = client.target("http://localhost:9001/").path("rest/saveUserInfo");
		JSONObject jsonObject = new JSONObject();
		jsonObject.element("id", "9527");
		jsonObject.element("age", "900");
		jsonObject.element("name", "独孤求败");

		Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(jsonObject));
		String retnStatusInfo = response.getStatusInfo().toString();

		String retnCode = response.readEntity(String.class);

		String retnHeader = response.getStringHeaders().toString();

		System.out.println("retnStatusInfo:" + retnStatusInfo + "\tretnStatus:" + response.getStatus());

		System.out.println("retnHeader:" + retnHeader);

		System.out.println("retnCode:" + retnCode + "\tretnCodeLength:" + retnCode.length());
	}

	public static void requestPathParamService() {
		WebTarget webTarget = client.target("http://localhost:9001/").path("rest/path/A00001");

		Response response = webTarget.request().post(Entity.html(null));

		int retnStatus = response.getStatus();

		String retnCode = response.readEntity(String.class);

		System.out.println("retnStatus:" + retnStatus);

		System.out.println("retnCode:" + retnCode);
	}

	public static void main(String[] args) {
		System.out.println("==============================================================");
		requestRest();
		System.out.println("==============================================================");
		postParamToRestService();
		System.out.println("==============================================================");
		requestPathParamService();
		System.out.println("==============================================================");
	}

}
