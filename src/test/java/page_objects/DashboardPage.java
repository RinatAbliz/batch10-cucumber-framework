package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	// local varible
	private WebDriver driver;
	private final String TITLE_TEXT = "Dashboard";
	private final String URL = "https://boratech-practice-app.onrender.com/dashboard";

	// Elements

	private By addExperience = By.xpath("//a[@href='/add-experience']");
	private By addEducation = By.xpath("//a[@href='/add-education']");
	private By titleText = By.xpath("//section//h1[text()='Dashboard']");

	// constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// action
	public void navigateTOAddExperiencePage() {
		driver.findElement(addExperience).click();
	}

	public void navigateTOAddEducationPage() {
		driver.findElement(addEducation).click();
	}

	public void pageValidation() {
		assertEquals(TITLE_TEXT, driver.findElement(titleText).getText());
		assertEquals(URL, driver.getCurrentUrl());

	}

}
