package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	// local varible
	private WebDriver driver;
	private WebDriverWait wait;
	private final String TITLE_TEXT = "Sign In";
	private final String URL = "https://boratech-practice-app.onrender.com/login";

	// Elements

	private By emailInput = By.xpath("//input[@name='email']");
	private By passwordInput = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By titleText = By.xpath("//section//h1[text()='Sign In']");
	private By errorAlert = By.xpath("//div[@class='alert alert-danger']");

	// constructor
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// action
	public void signIn(String email, String password) {
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();

	}

	public void checkAlert(String error) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorAlert));
		assertEquals(error, driver.findElement(errorAlert).getText());
	}

	public void pageValidation() {
		assertEquals(TITLE_TEXT, driver.findElement(titleText).getText());
		assertEquals(URL, driver.getCurrentUrl());

	}

}
