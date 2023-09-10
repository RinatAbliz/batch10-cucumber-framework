package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// local varible
	private WebDriver driver;
	private final String URL = "https://boratech-practice-app.onrender.com/";
	private final String TITLE_TAX = "BoraTech";
	// Elements
	@FindBy(how = How.XPATH, using = "//section//a[@href='/register']")
	private WebElement signUpButton;
	@FindBy(how = How.XPATH, using = "//section//a[@href='/login']")
	private WebElement loginButton;
	@FindBy(xpath = "//h1[@class='x-large']")
	private WebElement titleTax;

	// Constractor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// action
	public void navigeteToHomePage() {
		driver.get(URL);
	}

	public void clickOnLogin() {
		loginButton.click();
	}

	public void clinkOnSigin() {
		signUpButton.click();
	}

	public void checkPageLoad() {
		assertEquals(TITLE_TAX, titleTax.getText());
		assertEquals(URL, driver.getCurrentUrl());
	}

}
