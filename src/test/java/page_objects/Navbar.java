package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navbar {
	//local varible
	private WebDriver driver;
	
	
	//Elements
	
	private By homeLink=By.xpath("//a[@href=\"/\"]");
	private By registerLink = By.xpath("//nav//a[@href='/register']");
	private By loginLink = By.xpath("//nav//a[@href='/Login']");
	
	//constructor
	public Navbar(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//action
	public void returnHome(){
		driver.findElement(homeLink).click();
	}
	
	public void navigateToLoginPage() {
		driver.findElement(loginLink).click();
	}
	
	public void navigateToRegisterPage() {
		driver.findElement(registerLink).click();
	}
}
