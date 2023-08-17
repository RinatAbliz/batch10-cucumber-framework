package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Keywords;

public class MinimalAutomation {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String userName = "mochen703@gmail.com";
		String password = "As5889590";

		try {
			driver.get("https://minimals.cc/");
			driver.manage().window().fullscreen();

			driver.findElement(By.xpath("//a[@href='/dashboard']")).click();

			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(userName);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			WebElement user = driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div/nav/div/div/div/div[1]/div[2]/div/div/div/div[1]/ul[2]/div/div/div/div[1]/div[2]/span"));
			user.click();
			driver.findElement(By.xpath("//a[@href=\"/dashboard/user/list\"]")).click();
			driver.findElement(By.xpath("//span[text()='Role']/../../..")).click();
			driver.findElement(By.xpath("//li[@data-value='UX/UI Designer']")).click();
			driver.findElement(By.xpath("//li[@data-value='Software Developer']")).click();
			driver.findElement(By.tagName("body")).click();
			
			List<WebElement> selectedJobs= driver.findElements(By.xpath("//span[@class='MuiChip-label MuiChip-labelSmall css-tavflp']"));
			List<String> expactedTitles = new ArrayList<String>();
			for (WebElement SelectedJob : selectedJobs) {
				expactedTitles.add(SelectedJob.getText());
				
			}
		
			WebElement table = driver.findElement(By.xpath("//tbody[@class='MuiTableBody-root css-1xnox0e']"));
			List<WebElement> empoloyees = table.findElements(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-hover css-1d0u2ln']"));
			List<String> acturalTitle = new ArrayList<String>();
           for (WebElement empolyee : empoloyees) {
        	   List<WebElement> ActualTitles=empolyee.findElements(By.tagName("td"));
        	   acturalTitle.add(ActualTitles.get(4).getText());
			
		}
           Keywords.wait(5);
          for (String expac : expactedTitles) {
			if(!acturalTitle.contains(expac)) {
				throw new Exception("selected role"+expac+" did not show up");
			}
		} 
          
		

			Keywords.wait(1);
			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Field");
			System.out.println("Reason : " + e);
		} finally {
			driver.close();
			driver.quit();
		}
	}

}
