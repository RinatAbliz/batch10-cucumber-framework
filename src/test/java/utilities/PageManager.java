package utilities;

import org.openqa.selenium.WebDriver;

import page_objects.AddEducationPage;
import page_objects.DashboardPage;
import page_objects.ExperiencePage;
import page_objects.HomePage;
import page_objects.Navbar;
import page_objects.PostPage;
import page_objects.SignInPage;

public class PageManager {
	private static PageManager pageManager;
	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signIn;
	private Navbar navbar;
	private DashboardPage dashboard;
	private PostPage postPage;
	private AddEducationPage addEducation;
	private ExperiencePage addExperience;

	private PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public static PageManager getInstance() {
		if (pageManager == null) {
			pageManager = new PageManager(DriverManager.getInstance());
		}
		return pageManager;
	}

	public static void cleanUp() {
		pageManager = null;
	}

	public HomePage homePage() {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}

		return homePage;
	}

	public SignInPage signIn() {
		if (signIn == null) {
			signIn = new SignInPage(driver);
		}
		return signIn;
	}

	public Navbar navbar() {
		if (navbar == null) {
			navbar = new Navbar(driver);
		}
		return navbar;
	}

	public DashboardPage dashboard() {
		if (dashboard == null) {
			dashboard = new DashboardPage(driver);
		}
		return dashboard;
	}

	public PostPage postPage() {
		if (postPage == null) {
			postPage = new PostPage(driver);
		}
		return postPage;
	}

	public AddEducationPage getAddEducation() {
		if (addEducation == null) {
			addEducation = new AddEducationPage(driver);
		}

		return addEducation;
	}

	public ExperiencePage AddExperience() {
		if (addExperience == null) {
			addExperience = new ExperiencePage(driver);
		}
		return addExperience;
	}
}
