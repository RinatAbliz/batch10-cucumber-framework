package seleniumPractice;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utilities.Keywords;

public class CostcoTest extends BaseTest {
	static By homePage_searchBox = (By.xpath("//input[@name='keyword']"));
	static By PLP_addToCartButton = By.xpath("//*[contains(@id,'addbutton') and contains(text(),'Add')]");
	static By header_chartNumber = By.xpath("(//*[@class='cart-number ']//span)[3]");
	static By cartLink = By.id("cart-d");
	static By shoppingCart_pageTitle = By.id("id='cart-title'");

	public static void main(String[] args) throws InterruptedException {
		setUpTest("https://www.costco.com/");
		search_vilidation("chair");

		endTest();
	}

	public static void search_vilidation(String searchItem) throws InterruptedException {
		driver.findElement(homePage_searchBox).sendKeys(searchItem + Keys.ENTER);
		List<WebElement> addToCars = driver.findElements(PLP_addToCartButton);
		for (int i = 0; i < 4; i++) {
			addToCars.get(i).click();
			Keywords.wait(2);

		}
		String cartNumber = driver.findElement(header_chartNumber).getText();

		if (cartNumber.equals("4")) {
			System.out.println("passed");
		} else {
			System.out.println("Fail,");
			Assertions.fail("We dont have right amont of item in cart!");
		}
		driver.findElement(cartLink).click();
		String cartPageTitle = driver.findElement(shoppingCart_pageTitle).getText();

		Assertions.assertTrue(cartPageTitle.contains("4"), "The cart page shows wrong title" + cartPageTitle);

	}
}
