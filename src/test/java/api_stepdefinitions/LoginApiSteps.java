package api_stepdefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import utilities.BoraTechApi;
import utilities.DataManager;

public class LoginApiSteps {
	
	private DataManager dataManager = DataManager.getInstance();
    

	@Given("[API] User is logged in")
	public void api_user_is_logged_in(DataTable dataTable) {
	
		Map<String, String> userdata = dataTable.asMap();
		String email = userdata.get("userName");
		String password = userdata.get("password");

		String token = BoraTechApi.login(email, password);
		dataManager.setToken(token);

	}
}
