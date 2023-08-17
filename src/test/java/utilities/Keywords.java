package utilities;

import java.sql.Timestamp;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Keywords {
	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}

	public static String gitTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime() + "";
	}

	public static void waitWithoutTry(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (Exception e) {

		}
	}

	public static boolean checkIfElementExists(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void checkIfElementExists(WebDriver driver, By locator, String errorMessage) throws Exception {
		boolean found = checkIfElementExists(driver, locator);
		if (!found) {
			throw new Exception(errorMessage);
		}
	}

	public static void switchTOTheNewTab(WebDriver driver) {

		Set<String> handels = driver.getWindowHandles();
		String mainHandel = driver.getWindowHandle();
		for (String handel : handels) {
			if (!handel.equals(mainHandel)) {
				driver.switchTo().window(handel);
			}
		}
	}

}
