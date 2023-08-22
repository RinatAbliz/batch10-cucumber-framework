package api;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginApiTest {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();
		HashMap<String, String> body = new HashMap<String, String>();
		body.put("email", "mochen703@gmail.com");
		body.put("password", "As5889590");
		request.body(body);

		request.header("Content-Type", "application/json");

		Response response = request.post("api/auth");
		
		JsonPath jp = response.jsonPath();
		String token =  jp.get("token");
		System.out.println(token);

	}

}
