package ui_stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;

public class Hooks {

	@Before("@UI or @ui")
	public void setUp() {
		DriverManager.getInstance();
	}

	@After("@UI or @ui")
	public void cleanUp() {
		DriverManager.teardown();
	}
}
