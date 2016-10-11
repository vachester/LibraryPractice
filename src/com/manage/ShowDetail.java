package com.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.Execute;

public class ShowDetail extends ActionSupport{
	private String SelectedISBN;
	private Book SelectedBook;
	private Author SelectedAuthor;
	
	
	
	public ShowDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSelectedISBN(String SelectedISBN) {
		this.SelectedISBN = SelectedISBN;
	}
	
	public void setSelectedAuthor(Author SelectedAuthor) {
		this.SelectedAuthor = SelectedAuthor;
	}
	
	public void setSelectedBook(Book SelectedBook) {
		this.SelectedBook = SelectedBook;
	}
	
	public Author getSelectedAuthor() {
		return SelectedAuthor;
	}
	
	public Book getSelectedBook() {
		return SelectedBook;
	}
	
	public String getSelectedISBN() {
		return SelectedISBN;
	}
	
	public String Select(){
		String url = "jdbc:mysql://localhost:3306/BookDB";
		String username = "root";
		String password = "******";
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);	
			String sql = "select * from Book where ISBN=?";
			PreparedStatement selected_book_library = conn.prepareStatement(sql);
			selected_book_library.setString(1, SelectedISBN);
			ResultSet selected_book_data =  selected_book_library.executeQuery();
			if(selected_book_data.next()){
				String selected_author_id = selected_book_data.getString("AuthorID");
				String selected_book_title = selected_book_data.getString("Title");
				String selected_book_publisher = selected_book_data.getString("Publisher");
				String selected_book_publishdate = selected_book_data.getString("PublishDate");
				String selected_book_price = selected_book_data.getString("Price");
				SelectedBook = new Book(SelectedISBN, selected_book_title, Integer.parseInt(selected_author_id), selected_book_publisher, selected_book_publishdate, selected_book_price);
				sql = "select * from Author where AuthorID=?";
				PreparedStatement selected_author_library = conn.prepareStatement(sql);
				selected_author_library.setString(1, selected_author_id);
				ResultSet selected_author_data = selected_author_library.executeQuery();	
				if(selected_author_data.next()){
					String selected_author_name = selected_author_data.getString("Name");
					String selected_author_country = selected_author_data.getString("Country");
					String selected_author_age = selected_author_data.getString("Age");
					SelectedAuthor = new Author(Integer.parseInt(selected_author_id), selected_author_name, selected_author_country, selected_author_age);
				}
			}	
			
			
		}		
		catch(ClassNotFoundException e){
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}	
		catch(SQLException e){
			System.out.println("操作失误！");
			e.printStackTrace();
		}	
		finally {
			if(conn != null){
				try{
					conn.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		
		return SUCCESS;
	}
}
