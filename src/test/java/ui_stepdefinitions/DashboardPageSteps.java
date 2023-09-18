package ui_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.PageManager;

public class DashboardPageSteps {
	private PageManager page = PageManager.getInstance();

	@Then("user should see a success alert that says [Experience Added]")
	public void user_should_see_a_success_alert_that_says_experience_added() {
		page.dashboard().checkSuccessAlert("Experience Added");
	}

	@When("user is click Add Experience")
	public void user_is_click_add_experience() {
		page.dashboard().navigateTOAddExperiencePage();
	}

	@When("user is click Add Education")
	public void user_is_click_add_education() {
		page.dashboard().navigateTOAddEducationPage();
	}

	@Then("user will see - {string}")
	public void user_will_see(String string) {
		page.dashboard().checkSuccessAlert(string);
	}

}
