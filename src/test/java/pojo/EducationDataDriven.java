package pojo;

public class EducationDataDriven {
	public String school;
	public String degree;
	public String fieldOfStudy;
	public String from;
	public boolean current;
	public String to;
	public String description;

	public EducationDataDriven(String school, String degree, String fieldOfStudy, String from, 
			String to, String description,boolean current) {

		this.school = school;
		this.degree = degree;
		this.fieldOfStudy = fieldOfStudy;
		this.from = from;
		this.current = current;
		this.to = to;
		this.description = description;

	}
}
