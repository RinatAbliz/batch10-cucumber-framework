package api_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hpsf.Array;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

import apiPojos.ApiError;
import apiPojos.ExpreiencePojo;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.BoraTechApi;
import utilities.DataManager;

public class AddExperienceSteps {
	DataManager dataManager = DataManager.getInstance();

	@When("user is try to add new experience")
	public void user_is_try_to_add_new_experience(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		ExpreiencePojo expreience = new ExpreiencePojo(data.get("company"), data.get("title"), data.get("location"),
				data.get("from"), data.get("to"), data.get("description"), Boolean.valueOf(data.get("current")));

		List<ApiError> errors = BoraTechApi.addExperienceUnhappy(dataManager.getToken(), expreience);
		dataManager.setApiErrors(errors);
	}

	@Then("user will recevied error massage")
	public void user_will_recevied_error_massage(DataTable dataTable) {
		// pre
		List<String> expactedError = new ArrayList<String>();
		List<String> acturalError = new ArrayList<String>();

		// create actualError
		List<ApiError> errors = dataManager.getApiErrors();
		for (ApiError error : errors) {
			acturalError.add(error.msg);
		}
		System.out.println(acturalError);

		// create expactedError
		String csErrorString = dataTable.asMap().get("errors");
		String[] csErrors = csErrorString.split(",");
		for (String error : csErrors) {
			expactedError.add(error.trim());
		}
		System.out.println(expactedError);
		
		assertEquals(expactedError, acturalError,"expacted Error did not show up");

	}

}
