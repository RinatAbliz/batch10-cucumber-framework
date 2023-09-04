package api_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import apiPojos.Education;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.BoraTechApi;
import utilities.DataManager;

public class AddEducationSteps {
	DataManager dataManager = DataManager.getInstance();

	@Then("[API] user should be able to add new Education")
	public void api_user_should_be_able_to_add_new_education(DataTable dataTable) {
		String token = dataManager.getToken();
		Map<String, String> data = dataTable.asMap();
		Education expactedEducation = new Education(data.get("school"), data.get("degree"), data.get("FieldOfStudy"),
				data.get("from"), data.get("to"), Boolean.valueOf(data.get("current")), data.get("description"));
		List<Education> educations = BoraTechApi.addEducation(token, expactedEducation);
		boolean found = false;
		
		for (Education education : educations) {
			if(education.equals(expactedEducation)) {
				found=true;
			}
		}
		assertTrue(found,"newly add education not found");
	}

}
