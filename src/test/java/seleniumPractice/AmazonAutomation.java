package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAutomation {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
			loadLocation(driver);

			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Filed");
			System.out.println("Reason : " + e);
		}
	}

	public static void loadLocation(WebDriver driver) throws InterruptedException {
		driver.get(
				"https://www.amazon.com/?tag=hymsabk-20&ref=pd_sl_7j18redljw_e&adgrpid=1338106215055591&hvadid=83631877568167&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=90209&hvtargid=kwd-83631981824880:loc-190&hydadcr=28883_14559616");
		wait(2);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();

	}

	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);

	}

}
