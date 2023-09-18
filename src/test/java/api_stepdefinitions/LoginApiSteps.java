package api_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.BoraTechApi;
import utilities.DataManager;

public class LoginApiSteps {
	
	private DataManager dataManager = DataManager.getInstance();
    

	@Given("[API] User is logged in")
	public void api_user_is_logged_in(DataTable dataTable) {
	
		Map<String, String> userdata = dataTable.asMap();
		String email = userdata.get("email");
		String password = userdata.get("password");

		String token = BoraTechApi.login(email, password);
		dataManager.setToken(token);

	}
	
	@Given("[API] User is try to loggin")
	public void api_user_is_try_to_loggin(DataTable dataTable) {
		Map<String, String> userdata = dataTable.asMap();
		String email = userdata.get("userName");
		String password = userdata.get("password");
		String errorMessage = BoraTechApi.loginUnhappyPath(email, password);
		dataManager.setErrorMessage(errorMessage);
	   
	}

	@Then("[API] user is recevid loggin error")
	public void api_user_is_recevid_loggin_error(DataTable dataTable) {
	Map<String, String> error = dataTable.asMap();
	String expactedError = error.get("error");
	String actualError = dataManager.getErrorMessage();
	
	assertEquals(expactedError, actualError,"expactedError and actualError does not match");

	}



}
