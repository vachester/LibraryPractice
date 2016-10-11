package com.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteBook extends ActionSupport{
	private  String AuthorName,SelectedISBN;
	
	
	public DeleteBook() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSelectedISBN(String SelectedISBN) {
		this.SelectedISBN = SelectedISBN;
	}
	
	public void setAuthorName(String AuthorName) {
		this.AuthorName = AuthorName;
	}
	
	public String getAuthorName() {
		return AuthorName;
	}
	
	public String getSelectedISBN() {
		return SelectedISBN;
	}
	
	public String deletedb(){
		String url = "jdbc:mysql://localhost:3306/BookDB";
		String username = "root";
		String password = "******";
		Connection con_dele = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con_dele = DriverManager.getConnection(url, username, password);	
			String sql = "delete from Book where ISBN=?";
			PreparedStatement delete_book = con_dele.prepareStatement(sql);
			delete_book.setString(1, SelectedISBN);
			delete_book.executeUpdate();
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
			if(con_dele != null){
				try{
					con_dele.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return SUCCESS;
	}
}
