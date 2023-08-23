package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import apiPojos.BoraPost;
import apiPojos.User;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BoraTechApi {
	public static String login(String email, String password) {
		String endPoint = "api/auth";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		HashMap<String, String> body = new HashMap<String, String>();
		body.put("email", email);
		body.put("password", password);

		request.body(body);

		request.header("Content-Type", "application/json");

		Response response = request.post(endPoint);

		JsonPath jp = response.jsonPath();

		String token = jp.get("token");

		return token;

	}

	public static void getAuthorizedUserMeta(String token) {
		String endPoint = "api/auth";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);

		Response response = request.get(endPoint);

		String result = response.getBody().asPrettyString();

		System.out.println(result);

	}

	public static String addEducation(String token, HashMap<String, Object> body) {

		String endPoint = "api/profile/education";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.body(body);

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		Response response = request.put(endPoint);

		JsonPath jp = response.jsonPath();
		String school = jp.get("school");

		return school;

	}

	public static String addExperience(String token, HashMap<String, Object> body) {

		String endPoint = "api/profile/experience";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.body(body);

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		Response response = request.put(endPoint);
		JsonPath jp = response.jsonPath();
		String company = jp.get("company");

		return company;

	}

	public static User getUserMeta(String token) {

		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);

		Response response = request.get("api/auth");
		JsonPath jp = response.jsonPath();
		User user = jp.getObject("", User.class);
		return user;

	}

	public static void postANewpost(String token, String newPostText) {
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();
		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");
		String timeshit = Keywords.getTimeStamp();
		BoraPost body = new BoraPost(newPostText + timeshit);
		request.body(body);

		request.post("api/posts");

		Response response = request.get("api/posts");
		JsonPath jp = response.jsonPath();
		List<BoraPost> posts = jp.getList("", BoraPost.class);
		boolean found = false;
		for (BoraPost post : posts) {
			if (post.text.equals(body.text)) {
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Passed");
		} else {
			System.out.println("Field");

		}

	}

}
