package pojo;

import java.util.ArrayList;
import java.util.List;

public class Education {
	public String school;
	public String degree;
	public String fieldOfStudy;
	public String from;
	public boolean current;
	public String to;
	public String description;
	public List<String> expactedError;
	public boolean isHappyPath;

	public Education(String school, String degree, String fieldOfStudy, String from, boolean current, String to,
			String description, List<String> expactedError) {

		this.school = school;
		this.degree = degree;
		this.fieldOfStudy = fieldOfStudy;
		this.from = from;
		this.current = current;
		this.to = to;
		this.description = description;
		if (expactedError == null) {
			this.expactedError = new ArrayList<String>();
		} else {
			this.expactedError = expactedError;
		}
		this.isHappyPath = this.expactedError.size() == 0;

	}

}
