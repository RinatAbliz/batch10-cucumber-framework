package selenium;

import java.sql.Timestamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pojo.Experience;
import utilities.BoraTech;
import utilities.Keywords;

public class CreatBoratechProfile {
	public static void main(String[] args) {
		String userName = "mochen703@gmail.com";
		String password = "As5889590";

		WebDriver driver = new ChromeDriver();
		Experience exp_1 = new Experience("Casher", "CVS", "Fairfax", "05/12/2013", "02/12/2015",
				"Working hard everday", false);
		Experience exp_2 = new Experience("Manager", "Target", "Fairfax", "05/12/2015", "02/15/2016",
				"Working hard everday", false);
		Experience exp_3 = new Experience("driver", "food", "Fairfax", "05/12/2013", "", "Working hard everday", true);

		try {
			BoraTech.login(driver, userName, password);

			Experience[] experiecnes = { exp_1, exp_2, exp_3 };
			for (Experience experience : experiecnes) {
				BoraTech.AddExperience(driver, experience);
				Keywords.wait(1);
			}
			BoraTech.deleteAllExperiences(driver);

			System.out.println("Test Passed");

		} catch (Exception e) {
			System.out.println("Test Filed ");
			System.out.println("Reson : " + e);
		} finally {
			driver.quit();
		}

	}

	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}

	public static String getTimestamps() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime() + "";
	}

}
