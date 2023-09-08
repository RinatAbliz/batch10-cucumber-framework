package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	// local varible
	private WebDriver driver;
	private final String URL = "https://boratech-practice-app.onrender.com/";

	// Elements
	private By signUpButton = By.xpath("//section//a[@href='/register']");
	private By loginButton = By.xpath("//section//a[@href='/login']");

	// Constractor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// action
	public void navigeteToHomePage() {
		driver.get(URL);
	}

	public void clickOnLogin() {
		driver.findElement(loginButton).click();
	}

	public void clinkOnSigin() {
		driver.findElement(signUpButton).click();
	}

}
