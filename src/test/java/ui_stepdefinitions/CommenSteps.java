package ui_stepdefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.Keywords;
import utilities.PageManager;

public class CommenSteps {
	PageManager pages = PageManager.getInstance();

	@Given("User is logged in")
	public void user_is_logged_in(DataTable dataTable) throws InterruptedException {
		Map<String, String> userinfo = dataTable.asMap();
		String userName = userinfo.get("email");
		String password = userinfo.get("password");

		pages.homePage().navigeteToHomePage();
		pages.homePage().clickOnLogin();
		pages.signIn().signIn(userName, password);
		Keywords.wait(2);
		pages.dashboard().pageValidation();

	}

	@Given("user is on the BoraTech Dashboard page")
	public void user_is_on_the_bora_tech_dashboard_page(DataTable dataTable) {
		Map<String, String> userData = dataTable.asMap();
		String email = userData.get("email");
		String password = userData.get("password");
		pages.homePage().navigeteToHomePage();
		pages.homePage().clickOnLogin();
		pages.signIn().signIn(email, password);
		pages.dashboard().pageValidation();

	}

	@When("User navigates to the Post page")
	public void user_navigates_to_the_post_page() {
		pages.navbar().navigateToPostPage();
		pages.postPage().checkPageLoad();

	}
}
