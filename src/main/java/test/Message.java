package test;

public class Message 
{
	private String name;
	private String surName;
	private String text;

	public Message(String name, String surName, String text)
	{
		this.name = name;
		this.surName = surName;
		this.text = text;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
