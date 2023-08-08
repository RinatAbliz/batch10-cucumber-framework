package seleniumPractice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoraTechNagitiveTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String userName = "mochen703@gmail.com";
		String password = "As5889590";
		String jobTitle = "Manager" + gitTimeStamp();
		String company = "CVS";
		String location = "Fort Washington MD";
		String from = "02/12/2020";
		boolean current = true;
		String to = "02/05/2022";
		String description = "doing something everday";
		List<String> expactError = new ArrayList<String>();
		expactError.add("Title is required");
		expactError.add("Company is required");

		try {
			// this is fountion for log in to the webside
			driver.get("https://boratech-practice-app.onrender.com/dashboard");
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userName);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			// wait for page loading
			wait(2);
			driver.findElement(By.xpath("//a[@href='/add-experience']")).click();
			// wait for page loading
			wait(2);
			// filling out the from
			driver.findElement(By.xpath("//input[@name='title']")).sendKeys(jobTitle);
			driver.findElement(By.xpath("//input[@name='company']")).sendKeys(company);
			driver.findElement(By.xpath("//input[@name='location']")).sendKeys(location);
			driver.findElement(By.xpath("//input[@name='from']")).sendKeys(from);
			if (current == true) {
				driver.findElement(By.xpath("//input[@name='current']")).click();
			} else {
				driver.findElement(By.xpath("//input[@name='to']")).sendKeys(to);
			}
			driver.findElement(By.tagName("textarea")).sendKeys(description);

			driver.findElement(By.xpath("//input[@type='submit']")).click();
			wait(3);

			List<WebElement> errorAlerts = driver.findElements(By.xpath("//div[@class='alert alert-danger']"));
			List<String> actualErrors = new ArrayList<String>();
			for (WebElement error : errorAlerts) {
				actualErrors.add(error.getText());
			}
			if (actualErrors.size() != expactError.size()) {
				throw new Exception("Number of error does not match \n" + "Expacted Error : [" + expactError + "]\n"
						+ "Actual Error :[" + actualErrors + "]");
			}
			for (String expactedError : expactError) {
				if (!actualErrors.contains(expactedError)) {
					throw new Exception("Expacted Error is not found [ " + expactedError + " ]");
				}

			}

		} catch (Exception e) {
			System.out.println("Test Filed");
			System.out.println("Reason :" + e);

		} finally {
			 driver.close();
			 driver.quit();
		}

	}

	// this is the wait fountion
	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}

	public static String gitTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime() + "";
	}
}
