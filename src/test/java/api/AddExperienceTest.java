package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.BoraTechApi;
import apiPojos.*;

public class AddExperienceTest {
public static void main(String[] args) {
	String token = BoraTechApi.login("mochen703@gmail.com", "As5889590");
	RestAssured.baseURI="https://boratech-practice-app.onrender.com";
	RequestSpecification request = RestAssured.given();
	
	request.header("Content-Type", "application/json");
	request.header("x-auth-token", token);
	ExpreiencePojo exp_1=new ExpreiencePojo("BoraTech002", "manager", "Annandale", "2023-08-16", "", "", true);
	
	request.body(exp_1);
	Response response = request.put("/api/profile/experience");
	
	System.out.println(response.getStatusLine());
}
}
