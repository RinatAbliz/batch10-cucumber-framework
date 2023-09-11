package ui_stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.DashboardPage;
import page_objects.HomePage;
import page_objects.Navbar;
import page_objects.PostPage;
import page_objects.SignInPage;
import utilities.DriverManager;
import utilities.Keywords;

public class PostSteps {
	private WebDriver driver = DriverManager.getInstance();
	page_objects.HomePage homePage = new HomePage(driver);
	page_objects.SignInPage signIn = new SignInPage(driver);
	page_objects.Navbar navbar = new Navbar(driver);
	page_objects.DashboardPage dashboard = new DashboardPage(driver);
	page_objects.PostPage postPage = new PostPage(driver);

	@Given("User is logged in")
	public void user_is_logged_in(DataTable dataTable) throws InterruptedException {
		Map<String, String> userinfo = dataTable.asMap();
		String userName = userinfo.get("userName");
		String password = userinfo.get("password");

		homePage.navigeteToHomePage();
		homePage.clickOnLogin();
		signIn.signIn(userName, password);
		Keywords.wait(2);
		dashboard.pageValidation();

	}

	@When("User navigates to the Post page")
	public void user_navigates_to_the_post_page() {
		navbar.navigateToPostPage();
		postPage.checkPageLoad();

	}

	@When("User enter the post content")
	public void user_enter_the_post_content(DataTable dataTable) {
		Map<String, String> contents = dataTable.asMaps().get(0);
		String content = contents.get("content");
		postPage.creatANewPost(content + Keywords.getTimeStamp());

	}

	@When("User clink the submit button")
	public void user_clink_the_submit_button() {
		postPage.submitPost();
	}

	@Then("user should see a success alert that says - {string}")
	public void user_should_see_a_success_alert_that_says(String successAlertText) {
		postPage.createdAlertValidition();

	}
}
