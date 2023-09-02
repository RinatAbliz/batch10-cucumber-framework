package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverManager;

public class AddEducationSteps {
	private WebDriver driver = DriverManager.getInstance();

	@Given("user is on the BoraTech Dashboard page")
	public void user_is_on_the_bora_tech_dashboard_page(DataTable dataTable) {
		Map<String, String> userInfo = dataTable.asMap();
		String username = userInfo.get("userName");
		String password = userInfo.get("password");
		driver.get("https://boratech-practice-app.onrender.com/");
		driver.findElement(By.xpath("(//*[text()='Login'])[1]")).click();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		String actualTitle = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
		String expactedTitle = "Dashboard";
		assertEquals(expactedTitle, actualTitle,
				"Expacted Title is " + expactedTitle + " but actual Title is " + actualTitle);

	}

	@When("user is click Add Education")
	public void user_is_click_add_education() {
		driver.findElement(By.xpath("//a[@href='/add-education']")).click();

	}

	@When("user will be navagit to Add Education Page")
	public void user_will_be_navagit_to_add_education_page() {
		String actualTitle = driver.findElement(By.xpath("//h1[contains(text(),'Add Your Education')]")).getText();
		String expactedTitle = "Add Your Education";
		assertEquals(expactedTitle, actualTitle,
				"Expacted Title is " + expactedTitle + " but actual Title is " + actualTitle);

		String url = driver.getCurrentUrl();
		assertTrue(url.endsWith("add-education"));
	}

	@When("user enter the Education Information")
	public void user_enter_the_education_information(DataTable dataTable) {
		Map<String, String> educationInfo = dataTable.asMap();
		String school = educationInfo.get("school");
		String degree = educationInfo.get("degree");
		String fieldOfStudy = educationInfo.get("FieldOfStudy");
		String from = educationInfo.get("from");
		String to = educationInfo.get("to");
		String current = educationInfo.get("current");
		String description = educationInfo.get("description");
		driver.findElement(By.xpath("//input[@name='school']")).sendKeys(school);
		driver.findElement(By.xpath("//input[@name='degree']")).sendKeys(degree);
		driver.findElement(By.xpath("//input[@name='fieldofstudy']")).sendKeys(fieldOfStudy);
		driver.findElement(By.xpath("//input[@name='from']")).sendKeys(from);
		if (current.equals("true")) {
			driver.findElement(By.xpath("//input[@name='current']")).click();
		} else {
			driver.findElement(By.xpath("//input[@name='to']")).sendKeys(to);
		}
		driver.findElement(By.tagName("textarea")).sendKeys(description);

	}

	@When("user click the submit button")
	public void user_click_the_submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("user will see - {string}")
	public void user_will_see(String seccessAlert) {
		String acturalArlet = driver.findElement(By.xpath("//*[text()='Education Added']")).getText();
		assertEquals(seccessAlert, acturalArlet);

	}

}
