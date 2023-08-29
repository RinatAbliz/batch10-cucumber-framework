package ui_stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;

public class Hooks {

	@Before
	public void setUp() {
		DriverManager.getInstance();
	}

	@After
	public void cleanUp() {
		DriverManager.teardown();
	}
}
