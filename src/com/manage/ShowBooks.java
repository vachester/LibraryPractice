package com.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ShowBooks extends ActionSupport{
	private List<Author> ExistedAuthors = new ArrayList<Author>();
	private List<Book> ExistedBooks = new ArrayList<Book>();
	private String status;
	
	public ShowBooks() {
		// TODO Auto-generated constructor stub
	}
	
	public void setExistedAuthors(List<Author> ExistedAuthors) {
		this.ExistedAuthors = ExistedAuthors;
	}
	
	public void setExistedBooks(List<Book> ExistedBooks) {
		this.ExistedBooks = ExistedBooks;
	}
	
	public List<Author> getExistedAuthors() {
		return ExistedAuthors;
	}
	
	public List<Book> getExistedBooks() {
		return ExistedBooks;
	}
	
	public String execute(){
		String url = "jdbc:mysql://localhost:3306/BookDB";
		String username = "root";
		String password = "******";
		Connection con_exist = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con_exist = DriverManager.getConnection(url, username, password);	
			String sql = "select * from Book";
			Statement exist_book_library = con_exist.createStatement();
			ResultSet exist_book_data =  exist_book_library.executeQuery(sql);
			status = SUCCESS;
			while(exist_book_data.next()){
				System.out.println("ddd");
				String exit_author_id = exist_book_data.getString("AuthorID");
				String exit_book_title = exist_book_data.getString("Title");
				String exit_book_publisher = exist_book_data.getString("Publisher");
				String exit_book_publishdate = exist_book_data.getString("PublishDate");
				String exit_book_price = exist_book_data.getString("Price");
				String exit_book_isbn = exist_book_data.getString("ISBN");
				ExistedBooks.add(new Book(exit_book_isbn,exit_book_title,Integer.parseInt(exit_author_id),exit_book_publisher,exit_book_publishdate,exit_book_price));	
			}
			sql = "select * from Author";
			Statement exist_author_library = con_exist.createStatement();
			ResultSet exist_author_data =  exist_author_library.executeQuery(sql);
			status = SUCCESS;
			while(exist_author_data.next()){
				String exit_author_id = exist_author_data.getString("AuthorID");
				String exit_author_name = exist_author_data.getString("Name");
				String exit_author_age = exist_author_data.getString("Age");
				String exit_author_country = exist_author_data.getString("Country");
				ExistedAuthors.add(new Author(Integer.parseInt(exit_author_id),exit_author_name,exit_author_country,exit_author_age));	
			}	
		}		
		catch(ClassNotFoundException e){
			System.out.println("数据库连接失败！");
			status = ERROR;
			e.printStackTrace();
		}	
		catch(SQLException e){
			System.out.println("操作失误！");
			status = ERROR;
			e.printStackTrace();
		}	
		finally {
			if(con_exist != null){
				try{
					con_exist.close();
				}
				catch(SQLException e){
					status = ERROR;
					e.printStackTrace();
				}
			}
		}
		return status;
	}
}
