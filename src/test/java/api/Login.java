package api;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {
	public static void main(String[] args) {
		String endPoint = "api/auth";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		HashMap<String, String> body = new HashMap<String, String>();
		body.put("email", "mochen703@gmail.com");
		body.put("password", "As5889590");

		request.body(body);

		request.header("Content-Type", "application/json");

		Response response = request.post(endPoint);
		System.out.println(response.statusLine());
		System.out.println(response.statusCode());
		System.out.println(response.body().asString());

	}
}
