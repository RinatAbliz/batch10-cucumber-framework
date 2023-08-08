package selenium;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatBoratechProfile {
	public static void main(String[] args) {
		String jobTitle = "QA Tester";
		String companeyName = "Target" + getTimestamps();
		String location = "Maryland";
		String from = "02/01/2023";
		String to = "08/01/2023";
		String describtion = "do automation ";
		boolean current = true;
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://boratech-practice-app.onrender.com/dashboard");
			driver.findElement(By.name("email")).sendKeys("mochen703@gmail.com");
			driver.findElement(By.name("password")).sendKeys("As5889590");
			driver.findElement(By.xpath("//*[@id=\"root\"]/section/form/input")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@href=\"/add-experience\"]")).click();
			driver.findElement(By.name("title")).sendKeys(jobTitle);
			driver.findElement(By.name("company")).sendKeys(companeyName);
			driver.findElement(By.name("location")).sendKeys(location);
			driver.findElement(By.name("from")).sendKeys(from);
			if (current) {
				driver.findElement(By.xpath("//input[@type='checkbox']")).click();
			} else {
				driver.findElement(By.name("to")).sendKeys(to);
			}

			driver.findElement(By.tagName("textarea")).sendKeys(describtion);
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			Thread.sleep(3000);

			String Title = driver.findElement(By.xpath("//*[@id=\"root\"]/section/h1")).getText();
			if (Title.equals("Dashboard")) {
			} else {
				throw new Exception("Title does match expacted Title is Dashboard VS actral " + Title);
			}

			String tableElement = "//h2[text()='Experience Credentials']/following-sibling::table[1]";
			String rolElement = tableElement + "/tbody/tr";
			WebElement table = driver.findElement(By.xpath(tableElement));
			List<WebElement> rols = table.findElements(By.xpath(rolElement));
			boolean found = false;
			for (WebElement rol : rols) {
				List<WebElement> cells = rol.findElements(By.tagName("td"));
				String actualCompany = cells.get(0).getText();
				String actualTile = cells.get(1).getText();
				if (actualCompany.equals(companeyName) && actualTile.equals(jobTitle)) {
					found = true;
					break;

				}
				if (found == false) {
					throw new Exception("The newly input can not be found");
				}
			}

			System.out.println("Test Passed");

		} catch (Exception e) {
			System.out.println("Test Filed ");
			System.out.println("Reson : " + e);
		} finally {
			// driver.quit();
		}

	}

	public static void wait(int second) throws InterruptedException {
		Thread.sleep(second * 1000);
	}

	public static String getTimestamps() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime() + "";
	}

}
