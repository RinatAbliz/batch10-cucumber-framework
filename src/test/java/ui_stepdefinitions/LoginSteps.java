package ui_stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.DashboardPage;
import page_objects.HomePage;
import page_objects.SignInPage;
import utilities.DriverManager;
import utilities.Keywords;

public class LoginSteps {
	public WebDriver driver = DriverManager.getInstance();
	page_objects.HomePage homePage = new HomePage(driver);
	page_objects.SignInPage signIn = new SignInPage(driver);
	page_objects.DashboardPage dashboardPage = new DashboardPage(driver);

	@Given("user is on the boratech homepage")
	public void user_is_on_the_boratech_homepage() {
		homePage.navigeteToHomePage();
	}

	@When("user navigates to the Login page")
	public void user_navigates_to_the_login_page() {
		homePage.clickOnLogin();
		signIn.pageValidation();

	}

	@When("user enter the username - {string} and password - {string} and submit")
	public void user_enter_the_username_and_password_and_submit(String userName, String password)
			throws InterruptedException {
		signIn.signIn(userName, password);
		Keywords.wait(2);

	}

	@Then("User should be on the Dashboard page")
	public void user_should_be_on_the_dashboard_page() {
		dashboardPage.pageValidation();

	}

	@When("user enter the email and password and click on submit")
	public void user_enter_the_email_and_password_and_click_on_submit(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		String email = data.get("email");
		String password = data.get("password");
		signIn.signIn(email, password);
	}

	@Then("User will recived errorAlert")
	public void user_will_recived_error_alert(DataTable dataTable) {
		Map<String, String> errors = dataTable.asMap();
		String csError = errors.get("errors").trim();
		

		signIn.checkAlert(csError);

	}

}
