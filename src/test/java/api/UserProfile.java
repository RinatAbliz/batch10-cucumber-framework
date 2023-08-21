package api;

import java.util.HashMap;

import org.checkerframework.checker.units.qual.s;

import utilities.BoraTechApi;

public class UserProfile {
	public static void main(String[] args) {
		String token = BoraTechApi.login("mochen703@gmail.com", "As5889590");
		HashMap<String, String> educationBody = new HashMap<String, String>();
		educationBody.put("school", "Grorge Mason");
		educationBody.put("degree", "Computer");
		educationBody.put("fieldofstudy", "Automation");
		educationBody.put("from", "2015-03-22");
		educationBody.put("to", "2016-02-01");
		educationBody.put("current", "false");
		educationBody.put("description", "");
		
		HashMap<String, String> experienceBody = new HashMap<String, String>();
		experienceBody.put("company", "Alibaba");
		experienceBody.put("title", "java devaloper");
		experienceBody.put("location", "Arlington");
		experienceBody.put("from", "2013-08-08");
		experienceBody.put("to", "2016-09-06");
		experienceBody.put("current", "false");
		experienceBody.put("description", "");
		
		
		
		BoraTechApi.addExperience(token, experienceBody);
		
		

		//BoraTechApi.addEducation(token, educationBody);
	}
}
