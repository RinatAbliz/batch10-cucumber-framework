package seleniumPractice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoraTechAutomation {
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
		List<String> expactError=new ArrayList<String>();
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
			
			wait(2);
			//located Webside Title and compare Webside Title with actural Title
			String webTitle = driver.findElement(By.xpath("//h1[@class='large text-primary']")).getText();
			if (!webTitle.equals("Dashboard")) {
				throw new Exception("The web Title is not match the expacted Title \n" + "Excpact: Dashboard\n"
						+ "actural:" + webTitle);
			}
			
			//located experience table and compare the newest experience with what we input
			WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"root\"]/section/table[1]/tbody/tr"));
			List<WebElement> cells = tableElement.findElements(By.tagName("td"));

			String actualCompany = cells.get(0).getText();
			String actialJobToitle = cells.get(1).getText();

			if (!actualCompany.equals(company) && !actialJobToitle.equals(jobTitle)) {
				throw new Exception("newly creat Experience not found");
			}
		

			System.out.println("Test Passed");
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
