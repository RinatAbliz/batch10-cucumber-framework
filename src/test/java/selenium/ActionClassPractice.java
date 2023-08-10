package selenium;

import java.sql.Driver;
import java.util.List;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.Keywords;

public class ActionClassPractice {
	public static void main(String[] args) {
		draggable();
	}

	static void draggable() {
		WebDriver locaDriver = DataDrivenApplicationForm.dirverFactory();
		Actions ac = new Actions(locaDriver);

		try {
			locaDriver.get("https://jqueryui.com/droppable/");

			locaDriver.switchTo().frame(locaDriver.findElement(By.tagName("iframe")));
			ac.dragAndDrop(locaDriver.findElement(By.id("draggable")), locaDriver.findElement(By.id("droppable")))
					.build().perform();

			locaDriver.switchTo().defaultContent();

			locaDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[3]/a")).click();
			Keywords.wait(2);

			locaDriver.switchTo().frame(locaDriver.findElement(By.tagName("iframe")));

			ac.clickAndHold(locaDriver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"))).moveByOffset(200, -30)
					.build().perform();

			locaDriver.switchTo().defaultContent();
			locaDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[5]/a")).click();
			locaDriver.switchTo().frame(locaDriver.findElement(By.tagName("iframe")));
			WebElement allsorts = locaDriver.findElement(By.id("sortable"));
			List<WebElement> sortElement = allsorts.findElements(By.tagName("li"));
			ac.clickAndHold(sortElement.get(0)).moveByOffset(0, 80).release().build().perform();
			Keywords.wait(1);
			ac.clickAndHold(sortElement.get(0)).moveByOffset(0, 100).release().build().perform();
			Keywords.wait(1);
			ac.clickAndHold(sortElement.get(0)).moveByOffset(0, 120).release().build().perform();
			Keywords.wait(1);

			Keywords.wait(2);
			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Filed" + e);

		} finally {
			locaDriver.close();
			locaDriver.quit();
		}

	}

}
