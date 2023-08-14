package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pojo.Education;
import pojo.Experiecne;

public class BoraTech {

	public static void login(WebDriver driver, String userName, String password) throws InterruptedException {

		driver.get("https://boratech-practice-app.onrender.com/dashboard");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Keywords.wait(2);
	}

	public static void deleteAllExperiences(WebDriver driver) throws InterruptedException {
		int count = 0;
		while (true) {
			try {
				driver.findElement(By.xpath(
						"//h2[text()='Experience Credentials']/following-sibling::table[1]//button[@class='btn btn-danger']"))
						.click();
				Keywords.wait(1);
				count++;
			} catch (NoSuchElementException e) {
				break;
			}
		}
		if (count == 0) {
			System.out.println("No experience found that can be deleted.");
		} else {
			System.out.println("Successfully deleted " + count + " experience(s).");
		}
	}

	public static void AddExperience(WebDriver driver, Experiecne ex) throws Exception {

		driver.findElement(By.xpath("//a[@href=\"/add-experience\"]")).click();

		driver.findElement(By.name("title")).sendKeys(ex.jobTitle);

		driver.findElement(By.name("company")).sendKeys(ex.companeyName);

		driver.findElement(By.name("location")).sendKeys(ex.location);

		driver.findElement(By.name("from")).sendKeys(ex.from);

		if (ex.current) {
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		} else {
			driver.findElement(By.name("to")).sendKeys(ex.to);
		}

		driver.findElement(By.tagName("textarea")).sendKeys(ex.describtion);

		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

		Keywords.wait(2);

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
			if (actualCompany.equals(ex.companeyName) && actualTile.equals(ex.jobTitle)) {
				found = true;
				break;

			}
			if (found == false) {
				throw new Exception("The newly input can not be found");
			}
		}

		System.out.println("add experience Test Passed");

	}

	public static void addEducation(WebDriver driver, Education education) throws Exception {

		driver.findElement(By.xpath("//a[@href='/add-education']")).click();

		driver.findElement(By.xpath("//input[@name='school']")).sendKeys(education.school);
		driver.findElement(By.xpath("//input[@name='degree']")).sendKeys(education.degree);
		driver.findElement(By.xpath("//input[@name='fieldofstudy']")).sendKeys(education.fieldOfStudy);
		driver.findElement(By.xpath("//input[@name='from']")).sendKeys(education.from);
		if (education.current == true) {
			driver.findElement(By.xpath("//input[@name='current']")).click();
		} else {
			driver.findElement(By.xpath("//input[@name='to']")).sendKeys(education.to);
		}
		driver.findElement(By.tagName("textarea")).sendKeys(education.description);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Keywords.wait(2);

		System.out.println("Test Passed");

	}

}