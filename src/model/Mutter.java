package model;

public class Mutter {

	private String userName;
	private String text;
	public Mutter() {}
	public Mutter(String userName,String text) {
		this.userName=userName;
		this.text=text;
	}
	public String getUserName() {
		return userName;
	}
	public String getText() {
		return text;
	}

}
