package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String expectedName = "Akida Pulati";
		String expectedDate = "05/17/1992";
		try {
			driver.navigate().to("file:///D:/HTML&CSS/index.html");
			
			  WebElement tag = driver.findElement(By.tagName("h1")); String tagString =
			  tag.getText(); System.out.println("Title Text is: " + tagString); WebElement
			  subtag = driver.findElement(By.tagName("h3")); String subtagString =
			  subtag.getText(); System.out.println("Sub tag Text is: " + subtagString);
			 

			driver.findElement(By.id("name-input")).sendKeys(expectedName);

			driver.findElement(By.id("name-submit")).click();

			String actualName = driver.findElement(By.id("name-display")).getText();
			if (actualName.equals(expectedName)) {
				System.out.println("Pass");
			} else {
				System.out.println("field");
			}

			driver.findElement(By.id("dob-input")).sendKeys(expectedDate);

			driver.findElement(By.id("dob-submit")).click();

			String actualDate = driver.findElement(By.id("Dob-display")).getText();
			if (actualDate.equals(expectedDate)) {
				System.out.println("Pass");
			} else {
				System.out.println("field");
			}

			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
		}

	}

	public static boolean isHere(WebDriver driver, By by) {
		return driver.findElements(by).size() > 0;
	}
}
