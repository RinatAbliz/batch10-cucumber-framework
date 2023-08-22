package api;

import java.util.List;

import apiPojos.ExpreiencePojo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.BoraTechApi;

public class GetAuthorizedUserProfile {

	public static void main(String[] args) {
		String token = BoraTechApi.login("mochen703@gmail.com", "As5889590");
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();
		request.header("x-auth-token", token);

		request.header("Content-Type", "application/json");

		Response response = request.get("api/profile/me");

		JsonPath jp = response.jsonPath();
            
		List<ExpreiencePojo> expreiencies = jp.getList("experience",ExpreiencePojo.class);
        for (ExpreiencePojo expreience : expreiencies) {
			System.out.println(expreience.company);
			
		}
	}

}
