package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	// local varible
	private WebDriver driver;
	private final String TITLE_TEXT = "Dashboard";
	private final String URL = "https://boratech-practice-app.onrender.com/dashboard";

	// Elements

	@FindBy(xpath = "//a[@href='/add-experience']")
	private WebElement addExperience;
	@FindBy(xpath = "//a[@href='/add-education']")
	private WebElement addEducation;
	@FindBy(xpath = "//section//h1[text()='Dashboard']")
	private WebElement titleText;

//	private By addExperience = By.xpath("//a[@href='/add-experience']");
//	private By addEducation = By.xpath("//a[@href='/add-education']");
//	private By titleText = By.xpath("//section//h1[text()='Dashboard']");

	// constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
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
		assertEquals(TITLE_TEXT, titleText.getText());
		assertEquals(URL, driver.getCurrentUrl());

	}

}
