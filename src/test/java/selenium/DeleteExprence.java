package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.BoraTech;

public class DeleteExprence {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String userName = "mochen703@gmail.com";
		String password = "As5889590";
		try {
			BoraTech.login(driver, userName, password);
			BoraTech.deleteAllExperiences(driver);
			System.out.println("Test Passed");

		} catch (Exception e) {
			System.out.println("Test Filed");
			System.out.println("Reason : " + e.getMessage());

		} finally {
			driver.close();
			driver.quit();
		}

	}

}
