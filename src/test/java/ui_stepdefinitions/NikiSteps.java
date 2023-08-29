package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverManager;

public class NikiSteps {
	private WebDriver driver = DriverManager.getInstance();

	@Given("User is on the Nike homepage")
	public void user_is_on_the_nike_homepage() {
		driver.get("https://www.nike.com/");
		WebElement logo = driver.findElement(By.xpath("//a[@aria-label='Nike Home Page']"));
		assertTrue(logo.isDisplayed());
	}

	@When("User is searching for - {string}")
	public void user_is_searching_for(String searchItem) {
		driver.findElement(By.id("VisualSearchInput")).sendKeys("Air Jordan" + Keys.ENTER);
		;
	}

	@Then("User should see the products related to - {string}")
	public void user_should_see_the_products_related_to(String expectItem) {
		List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"product-card__title\"]"));
		String expectResult = "Air Jordan";
		boolean found = false;
		for (WebElement product : products) {
			if (product.getText().contains(expectResult)) {
				found = true;
				break;
			}
		}
		assertTrue(found);
	}
}
