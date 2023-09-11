package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPage {
	// local varible
	private final String TITEL_TEXT = "Posts";
	private final String URL = "https://boratech-practice-app.onrender.com/posts";
	private final String SUCCESS_ALERT = "Post Created";
	private WebDriver driver;

	// Elements
	@FindBy(xpath = "//section//h1[text()='Posts']")
	private WebElement titelText;
	@FindBy(xpath = "//section//textarea[@name='text']")
	private WebElement textBox;
	@FindBy(xpath = "//section//input[@type='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement successAlert;

	// cadition
	public PostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void creatANewPost(String postMessage) {
		textBox.sendKeys(postMessage);

	}

	public void submitPost() {
		submitButton.click();
	}

	public void checkPageLoad() {
		assertEquals(TITEL_TEXT, titelText.getText());
		assertEquals(URL, driver.getCurrentUrl());
	}

	public void createdAlertValidition() {
		assertTrue(successAlert.isDisplayed());
		assertEquals(SUCCESS_ALERT, successAlert.getText());
	}
}
