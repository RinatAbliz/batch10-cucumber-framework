package ui_stepdefinitions;

import java.util.Map;

import apiPojos.Post;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DataManager;
import utilities.Keywords;
import utilities.PageManager;

public class PostSteps {

	private PageManager pages = PageManager.getInstance();
	private DataManager data = DataManager.getInstance();

	@When("User enter the post content")
	public void user_enter_the_post_content(DataTable dataTable) {
		Map<String, String> contents = dataTable.asMaps().get(0);
		String content = contents.get("content");
		pages.postPage().creatANewPost(content + Keywords.getTimeStamp());

	}

	@When("User clink the submit button")
	public void user_clink_the_submit_button() {
		pages.postPage().submitPost();
	}

	@Then("user should see a success alert that says - {string}")
	public void user_should_see_a_success_alert_that_says(String successAlertText) {
		pages.postPage().createdAlertValidition();

	}

	@Then("user should see the post that was created previously")
	public void user_should_see_the_post_that_was_created_previously() {
		Post previouslyCreatedPost = data.getPost();
		pages.postPage().checkPreviouslyCreatedPost(previouslyCreatedPost);
	}

	@When("user deleted the post that was created previously")
	public void user_deleted_the_post_that_was_created_previously() {
		Post previouslyCreatedPost = data.getPost();
		pages.postPage().findAndDeletePost(previouslyCreatedPost).click();
		
	}

}
