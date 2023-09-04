package api_stepdefinitions;

import apiPojos.ExpreiencePojo;
import io.cucumber.java.en.Then;
import utilities.BoraTechApi;
import utilities.DataManager;

public class AddExperienceSteps {
	DataManager dataManager = DataManager.getInstance();

	@Then("[API] User should be able to add new experience")
	public void api_user_should_be_able_to_add_new_experience() {
		String token = dataManager.getToken();
		ExpreiencePojo expactedExpreience = new ExpreiencePojo("BoraTech001", "manager", "Annandale", "2022-05-16",
				"2023-05-16", " ", false);
		BoraTechApi.addExperience(token, expactedExpreience);

		

	}

}
