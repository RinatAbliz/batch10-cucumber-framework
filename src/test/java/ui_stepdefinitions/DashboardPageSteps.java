package ui_stepdefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.PageManager;

public class DashboardPageSteps {
	private PageManager page = PageManager.getInstance();

	@Given("user is on the BoraTech Dashboard page")
	public void user_is_on_the_bora_tech_dashboard_page(DataTable dataTable) {
		Map<String, String> userData = dataTable.asMap();
		String email = userData.get("email");
		String password = userData.get("password");
		page.homePage().navigeteToHomePage();
		page.homePage().clickOnLogin();
		page.signIn().signIn(email, password);
		page.dashboard().pageValidation();

	}

	@Then("user should see a success alert that says [Experience Added]")
	public void user_should_see_a_success_alert_that_says_experience_added() {
		page.dashboard().checkSuccessAlert("Experience Added");
	}

	@When("user is click Add Experience")
	public void user_is_click_add_experience() {
		page.dashboard().navigateTOAddExperiencePage();
	}

}
