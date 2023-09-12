package utilities;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pojo.EducationDataDriven;
import pojo.Experience;

public class Keywords {
	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}

	public static String getTimeStamp() {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		return timeStamp.getTime() + "";
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

	public static Experience convertMapToExperience(Map<String, String> data) {
		String company = data.get("company") == null ? "" : data.get("company") + getTimeStamp();
		String title = data.get("title") == null ? "" : data.get("title");
		String location = data.get("location") == null ? "" : data.get("location");
		String from = data.get("from") == null ? "" : data.get("from");
		String to = data.get("to") == null ? "" : data.get("to");
		boolean current = data.get("current") == null ? false : Boolean.valueOf(data.get("current"));
		String description = data.get("description") == null ? "" : data.get("description");

		Experience experience = new Experience(title, company, location, from, to, description, current);

		return experience;
	}

	public static EducationDataDriven convertMapToEducation(Map<String, String> data) {
		String school = data.get("school") == null ? "" : data.get("school") + getTimeStamp();
		String degree = data.get("degree") == null ? "" : data.get("degree");
		String FieldOfStudy = data.get("FieldOfStudy") == null ? "" : data.get("FieldOfStudy");
		String from = data.get("from") == null ? "" : data.get("from");
		String to = data.get("to") == null ? "" : data.get("to");
		String description = data.get("description") == null ? "" : data.get("description");
		boolean current = data.get("current") == null ? false : Boolean.valueOf(data.get("current"));
		EducationDataDriven education = new EducationDataDriven(school, degree, FieldOfStudy, from, to, description,
				current);

		return education;

	}

}
