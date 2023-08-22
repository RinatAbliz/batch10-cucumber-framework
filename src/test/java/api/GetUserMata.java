package api;

import apiPojos.User;
import utilities.BoraTechApi;

public class GetUserMata {

	public static void main(String[] args) {
		String token = BoraTechApi.login("mochen703@gmail.com", "As5889590");
		User user = BoraTechApi.getUserMeta(token);
		System.out.println(user.name); 

	}

}
