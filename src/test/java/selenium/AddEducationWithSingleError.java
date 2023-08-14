package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pojo.Education;
import utilities.BoraTech;

public class AddEducationWithSingleError {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String userName = "mochen703@gmail.com";
		String password = "As5889590";

		Education edu_1 = new Education("", "QA Tester", "QA Automation", "05/09/2023", true, "11/11/2023",
				"Working hard everday");
		try {
			BoraTech.login(driver, userName, password);
			BoraTech.addEducation(driver, edu_1);
		} catch (Exception e) {
			System.out.println("Test Filed");
			System.out.println("Reason: " + e);

		} finally {
			// driver.close();
			// driver.quit();
		}
	}

	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}

}
