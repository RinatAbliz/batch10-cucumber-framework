package api;

import utilities.BoraTechApi;

public class PostNewpost {
	public static void main(String[] args) {
		String newPost = "Hello";
		String token = BoraTechApi.login("mochen703@gmail.com", "As5889590");
		BoraTechApi.postANewpost(token, newPost);
		

	}

}
