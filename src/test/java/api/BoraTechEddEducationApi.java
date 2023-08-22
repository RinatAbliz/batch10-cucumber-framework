package api;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.BoraTechApi;

public class BoraTechEddEducationApi {

	public static void main(String[] args) {
		String token = BoraTechApi.login("mochen703@gmail.com", "As5889590");
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);
		JsonObject body = new JsonObject();
		body.addProperty("school", "harvord001");
		body.addProperty("degree", "QA cetified");
		body.addProperty("fieldofstudy", "Automation");
		body.addProperty("from", "2023-08-16");
		body.addProperty("to", "");
		body.addProperty("current", true);
		body.addProperty("description", "");
		request.body(body);
		Response response = request.put("api/profile/education");
		String result = response.getStatusLine();
		System.out.println(result);
		System.out.println(response.getBody().asPrettyString());

	}

}
