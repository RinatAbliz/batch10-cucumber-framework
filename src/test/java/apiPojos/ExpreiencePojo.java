package apiPojos;

public class ExpreiencePojo {
	public String company;
	public String title;
	public String location;
	public String from;
	public String to;
	public String describtion;
	public boolean current;

	public ExpreiencePojo(String company, String title, String location, String from, String to, String describtion,
			boolean current) {
		this.title = title;
		this.company = company;
		this.location = location;
		this.from = from;
		this.to = to;
		this.describtion = describtion;
		this.current = current;

	}

}
