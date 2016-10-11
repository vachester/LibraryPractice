package com.manage;

public class Book {
	private String ISBN,Title,Publisher,PublishDate,Price;
	private int AuthorID;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String ISBN,String Title,int AuthorID,String Publisher,String PublishData,String Price){
		this.ISBN = ISBN;
		this.Title = Title;
		this.AuthorID = AuthorID;
		this.Publisher = Publisher;
		this.PublishDate = PublishData;
		this.Price = Price;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public void setAuthorID(int AuthorID) {
		this.AuthorID = AuthorID;
	}
	
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}
	
	public void setPublishDate(String PublishDate) {
		this.PublishDate =PublishDate;
	}
	
	public void setPrice(String Price) {
		this.Price = Price;
	}
	
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public int getAuthorID() {
		return AuthorID;
	}

	public String getTitle() {
		return Title;
	}
	
	public String getPublisher() {
		return Publisher;
	}
	
	public String getPublishDate() {
		return PublishDate;
	}
	
	public String getPrice() {
		return Price;
	}
}

