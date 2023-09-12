package ui_stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DataManager;
import utilities.DriverManager;
import utilities.PageManager;

public class Hooks {

	@Before("@UI or @ui")
	public void setUp() {
		DriverManager.getInstance();
		DataManager.getInstance();
		PageManager.getInstance();
	}

	@After("@UI or @ui")
	public void cleanUp() {
		DriverManager.teardown();
		DataManager.cleanUp();
		PageManager.cleanUp();
	}
}
