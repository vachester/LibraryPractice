package com.manage;

import com.opensymphony.xwork2.ActionSupport;

public class OriginData extends ActionSupport{
	private String AuthorName,Publisher,PublishDate,Price,Title;
	public OriginData() {
		// TODO Auto-generated constructor stub
	}
	
	public void setAuthorName(String AuthorName) {
		this.AuthorName = AuthorName;
	}
	
	public void setPublishDate(String PublishDate) {
		this.PublishDate = PublishDate;
	}
	
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}
	
	public void setPrice(String Price) {
		this.Price = Price;
	}
	
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public String getPrice() {
		return Price;
	}
	
	public String getAuthorName() {
		return AuthorName;
	}
	
	public String getPublishDate() {
		return PublishDate;
	}
	
	public String getPublisher() {
		return Publisher;
	}
	
	public String getTitle() {
		return Title;
	}
}
