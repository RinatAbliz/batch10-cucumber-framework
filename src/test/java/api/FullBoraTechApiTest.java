package api;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import apiPojos.BoraPost;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.BoraTechApi;
import utilities.Keywords;

public class FullBoraTechApiTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String newPost = "Hello" + Keywords.getTimeStamp();
		String token = BoraTechApi.login("mochen703@gmail.com", "As5889590");

		String email = "mochen703@gmail.com";
		String password = "As5889590";
		try {
			driver.get("https://boratech-practice-app.onrender.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.linkText("Login")).click();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.findElement(By.xpath("//a[@href='/posts']")).click();
			driver.findElement(By.tagName("textarea")).sendKeys(newPost);
			driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click();

			RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
			RequestSpecification request = RestAssured.given();
			request.header("x-auth-token", token);
			Response response = request.get("api/posts");
			JsonPath jp = response.jsonPath();
			List<BoraPost> posts = jp.getList("", BoraPost.class);
			boolean found = false;
			for (BoraPost Post : posts) {
				if (Post.text.equals(newPost)) {
					found = true;
					break;
				}
			}
			if (!found) {
				throw new Exception("the new post did not found");
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
