package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.Keywords;

public class AutomationApplyPage {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String firstname = "Rinat";
		String lastname = "Abliz";
		String dob = "07/01/1994";
		boolean ganderMale = true;
		String emailAddress = "rinatabliz@gmail.com";
		String phone = "7034733141";
		String referredBy = "Nurali";

		try {
			// located apply page and loanding to the page
			driver.get("https://boratech-practice-app.onrender.com");
			driver.findElement(By.xpath("//a[@href='/apply']")).click();
			Keywords.wait(2);

			// varifay the page is the expacted page
			String actualUrl = driver.getCurrentUrl();
			if (!actualUrl.endsWith("/apply")) {
				throw new Exception("expact url does't match actual url");
			}
			String expactedTitle = "Application Form";
			String webTitle = driver.findElement(By.xpath("//h1[@class ='large text-primary']")).getText();
			if (!webTitle.equals(expactedTitle)) {
				throw new Exception("actual Web Title does not match the expacted title\n" + "Expacted :"
						+ expactedTitle + "\nActural :" + webTitle);
			}
			// Start filling out the form
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
			driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(dob);
			if (ganderMale == true) {
				driver.findElement(By.xpath("//input[@value='male']")).click();
			} else {
				driver.findElement(By.xpath("//input[@value='female']")).click();
			}
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);
			driver.findElement(By.xpath("//input[@name='phonenumber']")).sendKeys(phone);

			Select course = new Select(driver.findElement(By.xpath("//select[@name='course']")));
			course.selectByIndex(1);
			Select howDidHear = new Select(driver.findElement(By.xpath("//select[@name='source']")));
			howDidHear.selectByIndex(2);
			driver.findElement(By.xpath("//input[@name='referredby']")).sendKeys(referredBy);

			WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
			if (submitButton.isEnabled()) {
				throw new Exception("The submit button should be disable");
			}
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();

			if (!submitButton.isEnabled()) {
				throw new Exception("The submit button should be enable");
			}
			
			submitButton.click();
			String sacssAlert = driver.findElement(By.xpath("//*/div[@class='alert alert-success']")).getText();
			String expactedAlert = "you application is secass";
			
			
			Keywords.wait(2);
			if (!sacssAlert.equals(expactedAlert)) {
				throw new Exception("aleart is not match \n Expacted: " + expactedAlert + "\nActural: " + sacssAlert);
			}
		
			Keywords.wait(3);

			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
			System.out.println("Reason : " + e);

		} finally {
			// driver.close();
			// driver.quit();
		}

	}

}
