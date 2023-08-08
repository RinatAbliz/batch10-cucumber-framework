package selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddEducation_MultiError {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String school = "BoraTech";
		String degree = "";
		String fieldOfStudy = "QA Automation";
		String from = "05/09/2023";
		boolean current = true;
		String to = "11/11/2023";
		String description = "Working hard everday";

		List<String> expactErrors = new ArrayList<String>();
		expactErrors.add("School is required");
		expactErrors.add("Degree is required");
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
			List<WebElement> errorMassagies = driver.findElements(By.xpath("//div[@class='alert alert-danger']"));
			List<String> actualErrors = new ArrayList<>();
			for (WebElement errorMassage : errorMassagies) {
				actualErrors.add(errorMassage.getText());

			}
			if (actualErrors.size() != expactErrors.size()) {
				throw new Exception("Number of Error don't match\n"
						+"Expacted: "+expactErrors+"\n"+
						"Actural :" + actualErrors);
			}
			for (String expactedError : expactErrors) {
				if(!actualErrors.contains(expactedError)) {
					throw new Exception("Expected Error not found - ["+expactedError+"]");
				}
				
			}
			

			System.out.println("Test Passed");

		} catch (Exception e) {
			System.out.println("Test Filed");
			System.out.println("Reason: " + e);

		} finally {
			 driver.close();
			 driver.quit();
		}
	}

	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}

}
