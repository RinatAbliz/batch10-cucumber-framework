package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CostcoDyanamicWait {
 public static void main(String[] args) {
	 WebDriver driver = new ChromeDriver();
	try {
		driver.get("");
		
	} catch (Exception e) {
		
	}finally {
		driver.close();
		driver.quit();
	}
}

}
