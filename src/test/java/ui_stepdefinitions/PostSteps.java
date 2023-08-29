package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverManager;

public class PostSteps {
	private WebDriver driver = DriverManager.getInstance();

	@Given("User is logged in")
	public void user_is_logged_in(DataTable dataTable) {
		Map<String, String> userinfo = dataTable.asMap();
		String userName = userinfo.get("userName");
		String password = userinfo.get("password");
		driver.get("https://boratech-practice-app.onrender.com/");
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@When("User navigates to the Post page")
	public void user_navigates_to_the_post_page() {
		driver.findElement(By.xpath("//a[text()='Posts']")).click();
		String actualTagTitle = driver.findElement(By.xpath("//h1[text()='Posts']")).getText();
		String expectedTagTitle = "Posts";
		assertTrue(actualTagTitle.equals(expectedTagTitle),
				"expect title is" + expectedTagTitle + ",but actual tag title is " + actualTagTitle);
	}

	@When("User enter the post content")
	public void user_enter_the_post_content(DataTable dataTable) {
		Map<String, String> contents = dataTable.asMaps().get(0);
		String content = contents.get("content");

		driver.findElement(By.xpath("//textarea[@name='text']")).sendKeys(content);

	}

	@When("User clink the submit button")
	public void user_clink_the_submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("user should see a success alert that says - {string}")
	public void user_should_see_a_success_alert_that_says(String successAlertText) {
		try {
			driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		} catch (NoSuchElementException e) {
			assertTrue(false, "Expected to see an success alert but not found");
		}
		assertTrue(true);

	}
}
