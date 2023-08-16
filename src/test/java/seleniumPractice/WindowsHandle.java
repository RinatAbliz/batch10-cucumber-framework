package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Keywords;

public class WindowsHandle {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			driver.get("https://www.costco.com/");
			driver.manage().window().maximize();

			driver.findElement(By.xpath("//a[@target='_blank'][@href=\"https://costconext.com/\"]")).click();
			String mainHandel = driver.getWindowHandle();

			Keywords.switchTOTheNewTab(driver);
			String expactedUrl = "https://costconext.com/";
			String acturalUrl = driver.getCurrentUrl();

			if (!acturalUrl.equals(expactedUrl)) {
				throw new Exception(
						"Expacted Url is not exsited\n" + "Expact: " + expactedUrl + "\n" + "Actural: " + acturalUrl);
			}

			Keywords.checkIfElementExists(driver, By.id("what-is-costco-next"), "Expacted tag title is not exist");
			driver.close();
			driver.switchTo().window(mainHandel);
			driver.findElement(By.xpath("//a[@style='text-decoration:none'][@href=\"/all-costco-grocery.html\"]"))
					.click();
			String acturlTitle = driver.findElement(By.tagName("h1")).getText();
			String expactedTitle = "2-Day Delivery";
			if (!acturlTitle.equals(expactedTitle)) {
				throw new Exception("actual title does not match with Expacted Title");
			}
			driver.close();

			System.out.println("Test Passed");

		} catch (Exception e) {
			System.out.println("Test Field" + e);
			e.getLocalizedMessage();
		} finally {
			driver.quit();

		}

	}

}
