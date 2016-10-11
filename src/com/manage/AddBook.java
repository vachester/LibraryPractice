package com.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class AddBook extends ActionSupport{
	private String AuthorName,ISBN,Title,Publisher,PublishDate,Price;
	private String mess;
	private String Age,Country;
	private final String INPUT_ERROR = "input_error";
	public AddBook() {
		// TODO Auto-generated constructor stub
	}
	
	public void setAuthorName(String AuthorName) {
		this.AuthorName = AuthorName;
	}
	
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
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
	
	public void setAge(String Age) {
		this.Age = Age;
	}
	
	public void setCountry(String Country) {
		this.Country = Country;
	}
	
	public String getISBN() {
		return ISBN;
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
	
	public String getAuthorName() {
		return AuthorName;
	}
	
	public String getAge() {
		return Age;
	}
	
	public String getCountry() {
		return Country;
	}
	
	public String adddb(){
		String url = "jdbc:mysql://localhost:3306/BookDB";
		String username = "root";
		String password = "******";
		Connection con_add = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con_add = DriverManager.getConnection(url, username, password);	
			String sql = "select * from Author where Name=?";
			if(AuthorName!= null && !AuthorName.equals("")){
				PreparedStatement confirm_author_library = con_add.prepareStatement(sql);
				confirm_author_library.setString(1, AuthorName);
				ResultSet confirm_author_data =  confirm_author_library.executeQuery();
				if(confirm_author_data.next()){
					String AuthorID = confirm_author_data.getString("AuthorID");
					if(!ISBN.equals("") && !Title.equals("") && !Publisher.equals("") && !PublishDate.equals("") && !Price.equals("")){
						mess = SUCCESS;
						sql = "insert into Book (ISBN,Title,AuthorID,Publisher,PublishDate,Price) values (?,?,?,?,?,?)";
						PreparedStatement add_book_library = con_add.prepareStatement(sql);
						add_book_library.setString(1, ISBN);
						add_book_library.setString(2, Title);
						add_book_library.setInt(3, Integer.parseInt(AuthorID));
						add_book_library.setString(4, Publisher);
						add_book_library.setString(5, PublishDate);
						add_book_library.setString(6, Price);
						add_book_library.executeUpdate();
					}
					else{
						mess = INPUT_ERROR;
					}
				}
				else{
					if(!Age.equals("") && !Country.equals("")){
						sql="insert into Author (Name,Age,Country) values (?,?,?)";
						PreparedStatement add_author_library = con_add.prepareStatement(sql);
						add_author_library.setString(1, AuthorName);
						add_author_library.setString(2, Age);
						add_author_library.setString(3, Country);
						add_author_library.executeUpdate();
						sql = "select * from Author where Name=?";
						PreparedStatement search_author_library = con_add.prepareStatement(sql);
						search_author_library.setString(1, AuthorName);
						ResultSet search_author_data =  search_author_library.executeQuery();
						if(search_author_data.next()){
							if(!ISBN.equals("") && !Title.equals("") && !Publisher.equals("") && !PublishDate.equals("") && !Price.equals("")){
								mess = SUCCESS;
								sql = "insert into Book (ISBN,Title,AuthorID,Publisher,PublishDate,Price) values (?,?,?,?,?,?)";
								PreparedStatement add_book_library = con_add.prepareStatement(sql);
								String AuthorID = search_author_data.getString("AuthorID");
								add_book_library.setString(1, ISBN);
								add_book_library.setString(2, Title);
								add_book_library.setInt(3, Integer.parseInt(AuthorID));
								add_book_library.setString(4, Publisher);
								add_book_library.setString(5, PublishDate);
								add_book_library.setString(6, Price);
								add_book_library.executeUpdate();
							}
							else{
								mess = INPUT_ERROR;
							}
						}
					}
					else{
						mess = INPUT_ERROR;
					}
				}
			}
			else{
				mess = INPUT_ERROR;
			}
		}		
		catch(ClassNotFoundException e){
			System.out.println("数据库连接失败！");
			mess = ERROR;
			e.printStackTrace();
		}	
		catch(SQLException e){
			System.out.println("操作失误！");
			mess = ERROR;
			e.printStackTrace();
		}	
		catch(NumberFormatException e){
			System.out.println("输入不能为空！");
			mess = "input_error";
			e.printStackTrace();
		}	
		finally {
			if(con_add != null){
				try{
					con_add.close();
				}
				catch(SQLException e){
					mess = ERROR;
					e.printStackTrace();
				}
			}
		}
		return mess;
	}
}
