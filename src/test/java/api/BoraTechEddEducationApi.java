package api;

import java.util.List;

import apiPojos.Education;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.BoraTechApi;
import utilities.Keywords;

public class BoraTechEddEducationApi {

	public static void main(String[] args) {
		String token = BoraTechApi.login("mochen703@gmail.com", "As5889590");
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);
		Education body = new Education("MSN001" + Keywords.getTimeStamp(), "QA certified", "Automation", "2013-08-16",
				"2018-09-01", false, "Study hard everday");
		request.body(body);
		Response response = request.put("api/profile/education");

		JsonPath jp = response.jsonPath();
		List<Education> educations = jp.getList("education", Education.class);
		boolean found = false;
		for (Education education : educations) {
			if (body.equals(education)) {
				found = true;
				break;
			}
		}
		if (found == true) {
			System.out.println("Passed");
		} else {
			System.out.println("Feild");
		}

	}

}
