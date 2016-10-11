package com.manage;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;


public class ShowResults extends ActionSupport{
	private String re;
	//加入Value Stack Content
	private String AuthorName;
	private List<Author> authors = new ArrayList<Author>();
	private List<Book> books = new ArrayList<Book>();
	
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setAuthorName(String AuthorName){
		this.AuthorName = AuthorName;
	}
	public String getAuthorName(){
		return AuthorName;
	}
	public String match(){
		String url = "jdbc:mysql://localhost:3306/BookDB";
		String username = "root";
		String password = "******";
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);	
			String sql = "select * from Author where Name=?";
			PreparedStatement author_library = con.prepareStatement(sql);
			author_library.setString(1, AuthorName);
			ResultSet author_data =  author_library.executeQuery();
			re = SUCCESS;
			if(author_data.next()){
				String author_id = author_data.getString("AuthorID");
				String author_country = author_data.getString("Country");
				String author_age = author_data.getString("Age");
				authors.add(new Author(Integer.parseInt(author_id),author_country,AuthorName,author_age));
				sql = "select * from Book where AuthorID=?";
				PreparedStatement book_library = con.prepareStatement(sql);
				book_library.setString(1, author_id);
				ResultSet book_data = book_library.executeQuery();
				while(book_data.next()){
					String book_isbn = book_data.getString("ISBN");
					String book_title = book_data.getString("Title");
					String book_publisher = book_data.getString("Publisher");
					String book_publishdate = book_data.getString("PublishDate");
					String book_price = book_data.getString("Price");
					books.add(new Book(book_isbn,book_title,Integer.parseInt(author_id),book_publisher,book_publishdate,book_price));			
				}
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("数据库连接失败！");
			e.printStackTrace();
			re = ERROR;
		}	
		catch(SQLException e){
			System.out.println("操作失误！");
			e.printStackTrace();
			re = ERROR;
		}	
		finally {
			if(con != null){
				try{
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
					re = ERROR;
				}
			}
		}
		
		return re;
	}
	
}
