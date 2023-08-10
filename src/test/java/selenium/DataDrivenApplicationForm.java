package selenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Keywords;

public class DataDrivenApplicationForm {
	public static void main(String[] args) {

		HashMap<String, String> test_1 = new HashMap<String, String>();
		test_1.put("firstName", "Rinat");
		test_1.put("lastName", "Abliz");
		test_1.put("email", "rinatabli@gmail.com");
		test_1.put("subject", "Learning QA Automation");
		test_1.put("phonenumber", "7031112223");
		test_1.put("gender", "male");
		 submitApplicationForm(test_1);

		HashMap<String, String> test_2 = new HashMap<String, String>();
		test_2.put("firstName", "Rinat");
		test_2.put("lastName", "Abliz");
		test_2.put("email", "rinatabli@gmail.com");
		test_2.put("subject", "Learning QA Automation");
		// submitApplicationForm(test_2);

		HashMap<String, String> test_3 = new HashMap<String, String>();
		test_3.put("firstName", "Rinat");
		test_3.put("lastName", "Abliz");
		test_3.put("email", "rinatabli@gmail.com");
		test_3.put("subject", "Learning QA Automation");
		//submitApplicationForm(test_3);

	}

	public static void submitApplicationForm(HashMap<String, String> formData) {
		WebDriver localdriver = dirverFactory();

		try {
			localdriver.get("https://demoqa.com/automation-practice-form");
			Keywords.wait(2);
			for (String key : formData.keySet()) {
				switch (key.toLowerCase()) {
				case "firstname":
					localdriver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(formData.get(key));
					break;
				case "lastname":
					localdriver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(formData.get(key));
					break;
				case "email":
					localdriver.findElement(By.id("userEmail")).sendKeys(formData.get(key));
					break;
				case "phonenumber":
					localdriver.findElement(By.id("userNumber")).sendKeys(formData.get(key));
					break;
				case "subject":
					localdriver.findElement(By.id("subjectsInput")).sendKeys(formData.get(key));
					break;
				case "gender":
					selectgander(localdriver, formData.get(key));
					break;

				}

			}
			jsClick(localdriver, By.id("submit"));
			Keywords.wait(3);
			System.out.println("Test Passed");

		} catch (Exception e) {
			System.out.println("Test Field");
			System.out.println("Reason: " + e);
		}

	}

	private static void selectgander(WebDriver driver, String gender) {
		if (gender.equalsIgnoreCase("male")) {
			driver.findElement(By.xpath("//input[@value='Male']")).click();

		} else if (gender.equalsIgnoreCase("female")) {
			driver.findElement(By.xpath("//*[@id=\"gender-radio-2\"]")).click();

		} else {
			driver.findElement(By.xpath("//*[@id=\"gender-radio-3\"]")).click();
		}

	}

	public static WebDriver dirverFactory() {
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	static void jsClick(WebDriver driver, By by) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(by));
	}

}
