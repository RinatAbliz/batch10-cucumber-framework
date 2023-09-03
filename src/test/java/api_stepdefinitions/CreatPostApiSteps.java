package api_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import apiPojos.Post;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.BoraTechApi;
import utilities.DataManager;
import utilities.Keywords;

public class CreatPostApiSteps {
	private DataManager dataManager = DataManager.getInstance();

	@Then("[API] user should be able to created new post")
	public void api_user_should_be_able_to_created_new_post(DataTable dataTable) {
		List<Map<String, String>> contents = dataTable.asMaps();
		String expectedcontent = contents.get(0).get("content") + Keywords.getTimeStamp();
		String token = dataManager.getToken();
		Post post = BoraTechApi.createPost(token, expectedcontent);
		assertTrue(expectedcontent.equals(post.text));

	}
}