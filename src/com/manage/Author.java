package com.manage;

public class Author {
	private String Name,Country,Age;
	private int AuthorID;
	
	public Author() {
		//empty
	}
	
	public Author(int AuthorID,String Name,String Country,String Age){
		this.AuthorID = AuthorID;
		this.Name = Name;
		this.Country = Country;
		this.Age = Age;
	}
	
	public void setAuthorID(int AuthorID) {
		this.AuthorID = AuthorID;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setCountry(String Country) {
		this.Country = Country;
	}
	
	public void setAge(String Age) {
		this.Age = Age;
	}
	
	public int getAuthorID() {
		return AuthorID;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getCountry() {
		return Country;
	}
	
	public String getAge() {
		return Age;
	}
}
