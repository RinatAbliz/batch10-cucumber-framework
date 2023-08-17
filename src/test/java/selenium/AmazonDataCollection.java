package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pojo.AmazonSearchResult;
import utilities.Keywords;

public class AmazonDataCollection {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		List<AmazonSearchResult> results = new ArrayList<AmazonSearchResult>();
		String searchItem = "Shampoo";
		try {
			driver.get("https://www.amazon.com/");
			driver.manage().window().maximize();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem + Keys.ENTER);
			Keywords.checkIfElementExists(driver,
					By.xpath("//*[@data-component-type='s-result-info-bar']//*[contains(text(),'" + searchItem + "')]"),
					"Expected to be on search result page for shampoo ");
			int conter = 0;
			while (conter < 200) {

				String parentXpath = "(//div[@data-component-type='s-search-result'])";
				wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(parentXpath), 48));
				List<WebElement> cards = driver.findElements(By.xpath(parentXpath));

				for (int i = 1; i <= cards.size(); i++) {
					String titleXpath = parentXpath + "[" + i + "]//h2";
					String priceXpath = parentXpath + "[" + i + "]//span[@class='a-price']";

					String title = driver.findElement(By.xpath(titleXpath)).getText();
					String price = null;
					try {
						price = driver.findElement(By.xpath(priceXpath)).getText();
						price = price.replace("\n", ".").replace("$", "");
					} catch (NoSuchElementException e) {
						continue;
					}

					// System.out.println("ID : " + ++conter + " Price : " + price + " Title : " +
					// title);
					AmazonSearchResult result = new AmazonSearchResult(++conter, Double.valueOf(price), title);
					results.add(result);
					if (conter == 200) {
						break;
					}

				}
				if (conter == 200) {
					break;

				}
				driver.findElement(By.xpath(
						"//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"))
						.click();
			}

			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Field :" + e);

		} finally {
			driver.close();
			driver.quit();
		}
		for (AmazonSearchResult result : results) {
			System.out.println("ID :" + result.id + " price : " + result.price + " title : " + result.title);
		}
	}

}
