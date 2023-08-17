package pojo;

public class AmazonSearchResult {
	public int id;
	public String title;
	public double price;

	public AmazonSearchResult(int id, double price, String title) {
		this.id = id;
		this.title = title;
		this.price = price;
	}

}
