package utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import apiPojos.ApiError;
import apiPojos.Education;
import apiPojos.ExpreiencePojo;
import apiPojos.LoginRequest;
import apiPojos.Post;
import apiPojos.PostBody;
import apiPojos.User;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BoraTechApi {
	private static Response loginBase(String email, String password) {
		String endPoint = "api/auth";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		LoginRequest body = new LoginRequest(email, password);

		request.body(body);

		request.header("Content-Type", "application/json");

		Response response = request.post(endPoint);
		return response;
	}

	public static String login(String email, String password) {
		Response response = loginBase(email, password);

		JsonPath jp = response.jsonPath();

		assertEquals(200, response.getStatusCode());

		String token = jp.get("token");

		return token;

	}

	public static String loginUnhappyPath(String email, String password) {
		Response response = loginBase(email, password);

		assertEquals(400, response.getStatusCode());

		JsonPath jp = response.jsonPath();

		String msg = jp.get("errors[0].msg");
		assertNotNull(msg);
		return msg;
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

	public static List<Education> addEducation(String token, Education education) {

		String endPoint = "api/profile/education";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.body(education);

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		Response response = request.put(endPoint);
		assertEquals(200, response.statusCode());

		JsonPath jp = response.jsonPath();
		List<Education> educations = jp.getList("education", Education.class);
		return educations;

	}

	public static List<ApiError> addEducationUnhappy(String token, Education education) {
		String endPoint = "api/profile/education";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.body(education);

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");
		Response response = request.put(endPoint);
		assertEquals(400, response.getStatusCode());
		List<ApiError> errors = response.jsonPath().getList("errors", ApiError.class);
		assertTrue(errors.size() > 0, "Expected to received at least 1 error none received");
		return errors;
	}

	public static List<ExpreiencePojo> addExperience(String token, ExpreiencePojo expreience) {

		String endPoint = "api/profile/experience";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.body(expreience);

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		Response response = request.put(endPoint);
		JsonPath jp = response.jsonPath();

		List<ExpreiencePojo> expreiences = jp.getList("experience", ExpreiencePojo.class);
		assertTrue(expreiences.size() > 0, "No experience is created");
		return expreiences;

	}

	public static List<ApiError> addExperienceUnhappy(String token, ExpreiencePojo experience) {
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();
		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		request.body(experience);
		Response response = request.put("/api/profile/experience");
		int statusCode = response.getStatusCode();
		assertEquals(400, statusCode, "Expected statues code is 400 But get " + statusCode);
		List<ApiError> errors = response.jsonPath().getList("errors", ApiError.class);
		assertTrue(errors.size() > 0, "Expacted get atlast 1 error but not found");
		return errors;
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

	public static Post createPost(String token, String text) {
		String endpoint = "/api/posts";

		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		PostBody postBody = new PostBody(text);

		request.body(postBody);

		Response response = request.post(endpoint);
		assertEquals(200, response.statusCode());

		Post post = response.as(Post.class);
		return post;
	}

	public static List<Post> getPosts(String token) {
		String endpoint = "/api/posts";

		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		Response response = request.get(endpoint);
		assertEquals(200, response.statusCode());

		List<Post> post = response.jsonPath().getList("", Post.class);
		return post;
	}

}
