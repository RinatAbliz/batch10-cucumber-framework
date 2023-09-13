package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apiPojos.Post;

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
	@FindBy(xpath = "//div[@class='posts']//div[@class='post bg-white p-1 my-1']")
	private List<WebElement> postContainers;

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

	public void deletedAlertValidition() {
		assertTrue(successAlert.isDisplayed());
		assertEquals("Post Removed", successAlert.getText());
	}

	public void checkPreviouslyCreatedPost(Post post) {
		boolean found = false;
		for (WebElement postContainer : postContainers) {
			String userName = postContainer.findElement(By.tagName("h4")).getText();
			String content = postContainer.findElement(By.tagName("p")).getText();
			if (post.text.equals(content) && post.name.equals(userName)) {
				found = true;
				break;
			}

		}
		assertTrue(found, "Expacted post not found -User: " + post.name + "content : " + post.text);
	}

	public WebElement findAndDeletePost(Post post) {
		WebElement deleteButton = null;
		boolean found = false;
		for (WebElement postContainer : postContainers) {
			String userName = postContainer.findElement(By.tagName("h4")).getText();
			String content = postContainer.findElement(By.tagName("p")).getText();
			List<WebElement> buttons = postContainer.findElements(By.tagName("button"));
			if (post.text.equals(content) && post.name.equals(userName) && buttons.size() == 3) {
				deleteButton = buttons.get(2);
				found = true;
				break;
			}

		}
		assertTrue(found, "Expacted post not found -User: " + post.name + "content : " + post.text);
		return deleteButton;

	}
}
