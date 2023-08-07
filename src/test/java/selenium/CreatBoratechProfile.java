package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatBoratechProfile {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://boratech-practice-app.onrender.com/dashboard");
			driver.findElement(By.name("email")).sendKeys("mochen703@gmail.com");
			driver.findElement(By.name("password")).sendKeys("As5889590");
			driver.findElement(By.xpath("//*[@id=\"root\"]/section/form/input")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@href=\"/add-experience\"]")).click();
			driver.findElement(By.name("title")).sendKeys("QA Tester");
			driver.findElement(By.name("company")).sendKeys("Puri digit");
			driver.findElement(By.name("location")).sendKeys("Maryland");
			driver.findElement(By.name("from")).sendKeys("02/01/2023");
			driver.findElement(By.name("to")).sendKeys("08/01/2023");
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			/*
			 * WebElement descripbox = driver.findElement(By.name("description"));
			 * descripbox.click();
			 * 
			 * descripbox.sendKeys(" im here because i want to inprof myself");
			 * 
			 */
			Thread.sleep(2000);
			String Title = driver.findElement(By.xpath("//*[@id=\"root\"]/section/h1")).getText();
			if (Title.equals("Dashboard")) {
				System.out.println("Test passed");
			} else {
				throw new Exception("Title does match expacted Title is Dashboard VS actral " + Title);
			}
			driver.findElement(By.xpath("//*[@id=\"root\"]/section/table[1]/tbody/tr/td[4]/button"));

			System.out.println("Test Passed");

		} catch (Exception e) {
			System.out.println("Test Filed ");
			System.out.println("Reson : " + e);
		} finally {
			// driver.quit();
		}

	}

}
