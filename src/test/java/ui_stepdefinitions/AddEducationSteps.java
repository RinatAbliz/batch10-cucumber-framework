package ui_stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.Keywords;
import utilities.PageManager;

public class AddEducationSteps {
	private PageManager page = PageManager.getInstance();

	@When("user will be navagit to Add Education Page")
	public void user_will_be_navagit_to_add_education_page() {
		page.getAddEducation().validatePageLoad();

	}

	@When("user enter the Education Information")
	public void user_enter_the_education_information(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		page.getAddEducation().enterEducationData(Keywords.convertMapToEducation(data));
	}

	@When("user click the submit button")
	public void user_click_the_submit_button() {
		page.getAddEducation().submitEducation();
	}

	@Then("user will see ErrorAlert")
	public void user_will_see_error_alert(DataTable dataTable) {
		List<String> expactedError = new ArrayList<String>();
		Map<String, String> errors = dataTable.asMap();
		String csError = errors.get("alerts");
		String[] errorsAlerts = csError.split(",");
		for (String error : errorsAlerts) {
			expactedError.add(error.trim());
		}
		page.getAddEducation().checkErrorAlert(expactedError);
	}

}
