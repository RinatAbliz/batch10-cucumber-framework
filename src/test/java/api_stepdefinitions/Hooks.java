package api_stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DataManager;

public class Hooks {

	@Before("@API or @api")
	public void setUp() {
	 DataManager.getInstance();
	}

	@After("@API or @api")
	public void cleanUp() {
		DataManager.cleanUp();
	}
}
