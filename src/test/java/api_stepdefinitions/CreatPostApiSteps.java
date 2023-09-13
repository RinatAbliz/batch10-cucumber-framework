package api_stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
		dataManager.setPost(post);

	}

	@Then("[API] user can validate that the post they created previously is not there anymore")
	public void api_user_can_validate_that_the_post_they_created_previously_is_not_there_anymore() {
		String token = dataManager.getToken();
		Post previouslyCreatedPost = dataManager.getPost();
		List<Post> posts = BoraTechApi.getPosts(token);
		boolean found = false;
		for (Post post : posts) {
			if (post.equals(previouslyCreatedPost)) {
				found=true;
				break;
			}
		}
		assertFalse(found,"previously created Post is still there");
	}
}