package ui_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;
import utilities.DriverManager;

public class AmazonSteps {
	private WebDriver driver = DriverManager.getInstance();

	@Given("user is on the amazon homepage")
	public void user_is_on_the_amazon_homepage() {
		driver.get("https://www.amazon.com/");
		WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
		assertTrue(logo.isDisplayed(), "Expected to see the amazon logo but not found");

	}

	@When("user search for - {string} and submit")
	public void user_search_for_and_submit(String searchItem) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem + Keys.ENTER);
	}

	@Then("user should see the Items related - {string}")
	public void user_should_see_the_items_related(String searchItem) {
		List<WebElement> cardsTitles = driver.findElements(By.xpath(
				"//*[@data-component-type='s-search-result']//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
		boolean found = false;
		for (WebElement Title : cardsTitles) {
			if (Title.getText().contains(searchItem)) {
				found = true;
				break;

			}
		}
		assertTrue(found, "Expected " + searchItem + "does not found");
	}

}
