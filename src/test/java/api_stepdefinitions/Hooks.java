package api_stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DataManager;

public class Hooks {

	@Before("@API or @api or @E2E or @e2e")
	public void setUp() {
		DataManager.getInstance();
	}

	@After("@API or @api or @E2E or @e2e")
	public void cleanUp() {
		DataManager.cleanUp();
	}
}
