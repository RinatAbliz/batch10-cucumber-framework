package apiPojos;

public class BoraPost {
	public String text;

	public BoraPost(String text) {
		this.text = text;
	}
	public boolean equals(BoraPost that) {
		return this.text.equals(that.text);
	}
}
