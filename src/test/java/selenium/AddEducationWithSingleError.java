package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddEducationWithSingleError {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String school = "BoraTech";
		String degree = "";
		String fieldOfStudy = "QA Automation";
		String from = "05/09/2023";
		boolean current = true;
		String to = "11/11/2023";
		String description = "Working hard everday";
		String expactError = "School is required";
		try {
			driver.get("https://boratech-practice-app.onrender.com/dashboard");
			driver.findElement(By.name("email")).sendKeys("mochen703@gmail.com");
			driver.findElement(By.name("password")).sendKeys("As5889590");
			driver.findElement(By.xpath("//*[@id=\"root\"]/section/form/input")).click();
			wait(2);
			driver.findElement(By.xpath("//a[@href='/add-education']")).click();
			wait(2);

			driver.findElement(By.xpath("//input[@name='school']")).sendKeys(school);
			driver.findElement(By.xpath("//input[@name='degree']")).sendKeys(degree);
			driver.findElement(By.xpath("//input[@name='fieldofstudy']")).sendKeys(fieldOfStudy);
			driver.findElement(By.xpath("//input[@name='from']")).sendKeys(from);
			if (current == true) {
				driver.findElement(By.xpath("//input[@name='current']")).click();
			} else {
				driver.findElement(By.xpath("//input[@name='to']")).sendKeys(to);
			}
			driver.findElement(By.tagName("textarea")).sendKeys(description);

			driver.findElement(By.xpath("//input[@type='submit']")).click();

			wait(2);
			List<WebElement> errorMassage = driver.findElements(By.xpath("//div[@class='alert alert-danger']"));
			if (errorMassage.size() != 1) {
				throw new Exception("get more then 1 error massage");
			}
			String actualErrorMessage = errorMassage.get(0).getText();
			if (!actualErrorMessage.equals(expactError)) {
				throw new Exception("actual error message [ " + actualErrorMessage + " ] expancted error message ["
						+ expactError + " ] does not match");
			}

			System.out.println("Test Passed");

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
