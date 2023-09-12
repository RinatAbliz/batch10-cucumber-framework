package ui_stepdefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Keywords;
import utilities.PageManager;

public class PostSteps {
	
	private PageManager pages= PageManager.getInstance();

	@Given("User is logged in")
	public void user_is_logged_in(DataTable dataTable) throws InterruptedException {
		Map<String, String> userinfo = dataTable.asMap();
		String userName = userinfo.get("userName");
		String password = userinfo.get("password");

		pages.homePage().navigeteToHomePage();
		pages.homePage().clickOnLogin();
		pages.signIn().signIn(userName, password);
		Keywords.wait(2);
		pages.dashboard().pageValidation();

	}

	@When("User navigates to the Post page")
	public void user_navigates_to_the_post_page() {
		pages.navbar().navigateToPostPage();
		pages.postPage().checkPageLoad();

	}

	@When("User enter the post content")
	public void user_enter_the_post_content(DataTable dataTable) {
		Map<String, String> contents = dataTable.asMaps().get(0);
		String content = contents.get("content");
		pages.postPage().creatANewPost(content + Keywords.getTimeStamp());

	}

	@When("User clink the submit button")
	public void user_clink_the_submit_button() {
		pages.postPage().submitPost();
	}

	@Then("user should see a success alert that says - {string}")
	public void user_should_see_a_success_alert_that_says(String successAlertText) {
		pages.postPage().createdAlertValidition();

	}
}
