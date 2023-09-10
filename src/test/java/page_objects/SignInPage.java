package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	// local varible
	private WebDriver driver;
	private WebDriverWait wait;
	private final String TITLE_TEXT = "Sign In";
	private final String URL = "https://boratech-practice-app.onrender.com/login";

	// Elements

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailInput;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordInput;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//section//h1[text()='Sign In']")
	private WebElement titleText;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement errorAlert;

	// constructor
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// action
	public void signIn(String email, String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();

	}

	public void checkAlert(String error) {
		wait.until(ExpectedConditions.visibilityOf(errorAlert));
		assertEquals(error, errorAlert.getText());
	}

	public void pageValidation() {
		assertEquals(TITLE_TEXT, titleText.getText());
		assertEquals(URL, driver.getCurrentUrl());

	}

}
