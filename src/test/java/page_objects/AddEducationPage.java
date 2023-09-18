package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pojo.EducationDataDriven;

public class AddEducationPage {
	private final String URL = "https://boratech-practice-app.onrender.com/add-education";
	private final String TITLE_TEXT = "Add Your Education";
	private WebDriver driver;
	private WebDriverWait wait;

	// Elements
	@FindBy(xpath = "//form//input[@placeholder='* School or Bootcamp']")
	private WebElement school;
	@FindBy(xpath = "//form//input[@placeholder='* Degree or Certificate']")
	private WebElement degree;
	@FindBy(xpath = "//form//input[@placeholder='Field of Study']")
	private WebElement fieldOfStudy;
	@FindBy(xpath = "//form//input[@name='from']")
	private WebElement from;
	@FindBy(xpath = "//form//input[@name='to']")
	private WebElement to;
	@FindBy(xpath = "//form//input[@name='current']")
	private WebElement current;
	@FindBy(xpath = "//form//textarea[@name='description']")
	private WebElement description;
	@FindBy(xpath = "//form//input[@type='submit']")
	private WebElement submit;
	@FindBy(xpath = "//h1[@class='large text-primary']")
	private WebElement titleText;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private List<WebElement> ErrorAlerts;
	

	// constractor
	public AddEducationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	// actions
	public void enterEducationData(EducationDataDriven education) {
		school.sendKeys(education.school);
		degree.sendKeys(education.degree);
		fieldOfStudy.sendKeys(education.fieldOfStudy);
		from.sendKeys(education.from);

		if (education.current == true) {
			current.click();
		} else {
			to.sendKeys(education.to);
		}
		description.sendKeys(education.description);
	}

	public void submitEducation() {
		submit.click();
	}

	public void validatePageLoad() {
		assertEquals(URL, driver.getCurrentUrl());
		assertEquals(TITLE_TEXT, titleText.getText());

	}

	public void checkErrorAlert(List<String> expactedError) {
		List<String> actualError = new ArrayList<String>();
		for (WebElement error : ErrorAlerts) {
			actualError.add(error.getText());
		}
		Collections.sort(actualError);
		Collections.sort(expactedError);
		assertEquals(expactedError, actualError);
	}

}
