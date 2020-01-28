package test;

public class Message 
{
	private String name;
	private String surName;

	public Message(String name, String surName)
	{
		this.name = name;
		this.surName = surName;
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
		return "Ciao " + name + " " + surName;
	}
}
