package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navbar {
	// local varible
	private WebDriver driver;

	// Elements
	@FindBy(xpath = "//a[@href=\"/\"]")
	private WebElement homeLink;
	@FindBy(xpath = "//nav//a[@href='/register']")
	private WebElement registerLink;
	@FindBy(xpath = "//nav//a[@href='/Login']")
	private WebElement loginLink;
	@FindBy(xpath = "//nav//a[@href='/posts']")
	private WebElement post;

	// constructor
	public Navbar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// action
	public void returnHome() {
		homeLink.click();
	}

	public void navigateToLoginPage() {
		loginLink.click();
	}

	public void navigateToRegisterPage() {
		registerLink.click();
	}

	public void navigateToPostPage() {
		post.click();
	}
}
