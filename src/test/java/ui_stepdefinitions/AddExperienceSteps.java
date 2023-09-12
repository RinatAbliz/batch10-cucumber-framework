package ui_stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pojo.Experience;
import utilities.DriverManager;
import utilities.Keywords;
import utilities.PageManager;

public class AddExperienceSteps {
	public WebDriver driver = DriverManager.getInstance();
	public PageManager page = PageManager.getInstance();

	@When("user will be navagit to Add Experience Page")
	public void user_will_be_navagit_to_add_experience_page() {
		page.AddExperience().validatePageload();
	}

	@When("user enter the Experience Information")
	public void user_enter_the_experience_information(DataTable dataTable) throws InterruptedException {
		Map<String, String> data = dataTable.asMap();
		Experience expreience = Keywords.convertMapToExperience(data);
		page.AddExperience().addExperience(expreience);
		

	}

	@Then("user will see Alert")
	public void user_will_see_alert(DataTable dataTable) {
		List<String> expectedErrors = new ArrayList<>();

		// Convert expected errors
		String csErrorString = dataTable.asMap().get("alerts");
		String[] csErrors = csErrorString.split(",");
		for (String error : csErrors) {
			expectedErrors.add(error.trim());
		}
		page.AddExperience().errorValidation(expectedErrors);

	}

}
