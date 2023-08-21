package seleniumPractice;

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

import pojo.WalmartSearchResult;

public class WalmartDataCollection {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String searchItem = "toys";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		List<WalmartSearchResult> results = new ArrayList<WalmartSearchResult>();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			driver.get("https://www.target.com/");
			driver.findElement(By.id("search")).sendKeys(searchItem, Keys.ENTER);
			driver.findElement(By.xpath("//a[@data-lnk='c_bubcat_Toy Deals']")).click();
			driver.findElement(By.xpath("//a[@href='/c/toy-deals/2-4-years/-/N-55fjfZdyksm']")).click();

			int counter = 1;

			while (counter < 100) {
				String cardXpath = "(//div[@class='styles__StyledCol-sc-fw90uk-0 dOpyUp'])";
				List<WebElement> cards = driver
						.findElements(By.xpath("//div[@class='styles__StyledCol-sc-fw90uk-0 dOpyUp']"));

				wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(cardXpath), 20));
				for (int i = 1; i < cards.size(); i++) {
					String titleXpath = cardXpath + "[" + i + "]//*[@data-test='product-title']";
					String priceXpath = cardXpath + "[" + i + "]//*[@class='h-text-red']";
					String title = "";
					String price = "";
					try {

						title = driver.findElement(By.xpath(titleXpath)).getText();
						price = driver.findElement(By.xpath(priceXpath)).getText();
						
					} catch (NoSuchElementException e) {
						continue;
					}
					counter++;

					System.out.println("ID : " + counter + " Price : " + price + " Title : " + title);
					if (counter == 100) {
						break;
					}

				}
				if (counter == 100) {
					break;
				}

				
				
				driver.findElement(By.xpath("//button[@aria-label=\"next page\"] [@data-test='next']")).click();

			}
			for (WalmartSearchResult Result : results) {
				System.out.println("ID : " + Result.id + " Price : " + Result.price + " Title : " + Result.title);

			}

			System.out.println("Test Passed");

		} catch (Exception e) {
			System.out.println("Test Field" + e);

		} finally {
			driver.close();
			driver.quit();
		}
	}

}
