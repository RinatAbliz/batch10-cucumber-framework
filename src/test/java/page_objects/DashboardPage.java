package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	// local varible
	private WebDriver driver;
	private WebDriverWait wait;
	private final String TITLE_TEXT = "Dashboard";
	private final String URL = "https://boratech-practice-app.onrender.com/dashboard";

	// Elements

	@FindBy(xpath = "//a[@href='/add-experience']")
	private WebElement addExperience;
	@FindBy(xpath = "//a[@href='/add-education']")
	private WebElement addEducation;
	@FindBy(xpath = "//section//h1[text()='Dashboard']")
	private WebElement titleText;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement successAlert;

	// constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// action
	public void navigateTOAddExperiencePage() {
		addExperience.click();
	}

	public void navigateTOAddEducationPage() {
		addEducation.click();
	}

	public void pageValidation() {
		wait.until(ExpectedConditions.urlToBe(URL));
		wait.until(ExpectedConditions.textToBePresentInElement(titleText, TITLE_TEXT));

		assertEquals(TITLE_TEXT, titleText.getText());
		assertEquals(URL, driver.getCurrentUrl());

	}

	public void checkSuccessAlert(String alert) {
		assertTrue(successAlert.isDisplayed());
		assertEquals(alert, successAlert.getText());
	}

}
