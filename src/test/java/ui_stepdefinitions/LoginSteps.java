package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverManager;
import utilities.Keywords;

public class LoginSteps {
	public WebDriver driver = DriverManager.getInstance();

	@Given("user is on the boratech homepage")
	public void user_is_on_the_boratech_homepage() {

		driver.get("https://boratech-practice-app.onrender.com/");
		int loginElementscount = driver.findElements(By.xpath("//a[text()='Login']")).size();
		assertEquals(2, loginElementscount);
	}

	@When("user navigates to the Login page")
	public void user_navigates_to_the_login_page() {
		driver.findElement(By.xpath("//*[@class='btn btn-light']")).click();
		String url = driver.getCurrentUrl();
		assertTrue(url.endsWith("login"));
		String actualTitleText = driver.findElement(By.xpath("//h1[@class=\"large text-primary\"]")).getText();
		String expectedTitleText = "Sign In";
		assertEquals(expectedTitleText, actualTitleText);

	}

	@When("user enter the username - {string} and password - {string} and submit")
	public void user_enter_the_username_and_password_and_submit(String userName, String password) throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Keywords.wait(2);

	}

	@Then("User should be on the Dashboard page")
	public void user_should_be_on_the_dashboard_page() {
		String url = driver.getCurrentUrl();
		assertTrue(url.endsWith("dashboard"));

		String actualTitleText = driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
		String expectedTitleText = "Dashboard";
		assertEquals(expectedTitleText, actualTitleText);

	}

}
