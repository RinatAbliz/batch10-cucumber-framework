package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import pojo.Education;
import pojo.Experience;

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

	public static void AddExperience(WebDriver driver, Experience ex) throws Exception {

		driver.findElement(By.xpath("//a[@href=\"/add-experience\"]")).click();

		driver.findElement(By.name("title")).sendKeys(ex.title);

		driver.findElement(By.name("company")).sendKeys(ex.companey);

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
			if (actualCompany.equals(ex.companey) && actualTile.equals(ex.title)) {
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

	}

	public static void addEducationvalidation(WebDriver driver, Education education, boolean isHappryPath)
			throws Exception {
		if (isHappryPath == true) {
			addEducationHappyPath(driver, education);

		} else {
			addEducationsadPath(driver, education);

		}

	}

	private static void addEducationsadPath(WebDriver driver, Education education) throws Exception {

		List<WebElement> errorMassagies = driver.findElements(By.xpath("//div[@class='alert alert-danger']"));
		List<String> actualErrors = new ArrayList<>();
		for (WebElement errorMassage : errorMassagies) {
			actualErrors.add(errorMassage.getText());

		}
		if (actualErrors.size() != education.expactedError.size()) {
			throw new Exception("Number of Error don't match\n" + "Expacted: " + education.expactedError + "\n"
					+ "Actural :" + actualErrors);
		}
		for (String expactedError : education.expactedError) {
			if (!actualErrors.contains(expactedError)) {
				throw new Exception("Expected Error not found - [" + expactedError + "]");
			}

		}

	}

	public static void addEducationHappyPath(WebDriver driver, Education education) throws Exception {
		By educationTableLocator = RelativeLocator.with(By.tagName("table"))
				.below(By.xpath("//h2[text()='Education Credentials']"));
		WebElement educationTable = driver.findElement(educationTableLocator);
		List<WebElement> rows = educationTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

		boolean found = false;
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String school = cells.get(0).getText();
			String degree = cells.get(1).getText();
			if (education.school.equals(school) && education.degree.equals(degree)) {
				found = true;
				break;
			}

		}
		if (found == false) {
			throw new Exception("The newly enter education is not found");
		}

	}

	public static void deletedAllExsetingEducation(WebDriver driver, Education education) throws InterruptedException {
		int count = 0;
		while (true) {
			try {
				driver.findElement(By.xpath(
						"//h2[text()='Education Credentials']/following-sibling::table[1]//button[@class='btn btn-danger']"))
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

}
