package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoratechLogin {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {

			driver.get("https://boratech-practice-app.onrender.com/");
			driver.findElement(By.linkText("Login")).click();
			Thread.sleep(2000);
			String title = driver.findElement(By.xpath("//*[@id=\"root\"]/section/h1")).getText();
			System.out.println("Title is: " + title);

			driver.findElement(By.name("email")).sendKeys("mochen703@gmail.com");
			driver.findElement(By.name("password")).sendKeys("As5889590");
			driver.findElement(By.xpath("//*[@id=\"root\"]/section/form/input")).click();
			Thread.sleep(2000);
			String ecpactedResult = driver.findElement(By.xpath("//*[@id=\"root\"]/section/h1")).getText();

			if (ecpactedResult.equals("Dashboard")) {
				System.out.println("Test Passed");
			} else {
				throw new Exception("Title Text is does not match , Expected: Dashborad VS Actual : " + ecpactedResult);
			}
			String currentUrl = driver.getCurrentUrl();
			if (!currentUrl.endsWith("/dashboard")) {
				throw new Exception("The pag url is wrong ");
			}
			driver.findElement(By.xpath("//*[@id=\"root\"]/nav/ul/li[4]/a/span"));
		} catch (Exception e) {
			System.out.println("Test Filed");
			System.out.println("Reson :" + e.getMessage());
		} finally {
			//driver.quit();
		}

	}

}
