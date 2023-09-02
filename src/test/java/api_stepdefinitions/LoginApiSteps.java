package api_stepdefinitions;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginApiSteps {
	Response response;

	@Given("call login api with {string} and {string}")
	public int call_login_api(String email, String password) {
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();
		HashMap<String, String> body = new HashMap<String, String>();
		body.put("email", email);
		body.put("password", password);
		request.body(body);

		request.header("Content-Type", "application/json");

		response = request.post("api/auth");
		int code = response.getStatusCode();
		return code;

	}

	@Then("we should get response code {int}")
	public void we_should_get_response_code(Integer expactedStatusCode) {
		int actualStatusCode = response.getStatusCode();
		
		Assertions.assertTrue(expactedStatusCode==actualStatusCode,"Status code doest not match expected");

	}
}
