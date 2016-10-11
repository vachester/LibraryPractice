package com.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xalan.internal.xsltc.compiler.SyntaxTreeNode;
import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.swing.internal.plaf.metal.resources.metal_sv;

public class EditBook extends ActionSupport{
	private String eAuthorName,ePublisher,ePublishDate,ePrice,eTitle,eCountry;
	private String me;
	private String eAge;
	private final String INPUT_ERROR = "input_error";
	public EditBook() {
		// TODO Auto-generated constructor stub
	}
	
	public void seteAge(String eAge) {
		this.eAge = eAge;
	}
	
	public void seteCountry(String eCountry) {
		this.eCountry = eCountry;
	}
	
	public void seteAuthorName(String eAuthorName) {
		this.eAuthorName = eAuthorName;
	}
	
	public void setePrice(String ePrice) {
		this.ePrice = ePrice;
	}
	
	public void setePublishDate(String ePublishDate) {
		this.ePublishDate = ePublishDate;
	}
	
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	
	public void setePublisher(String ePublisher) {
		this.ePublisher = ePublisher;
	}
	
	public String geteAuthorName() {
		return eAuthorName;
	}
	
	public String getePrice() {
		return ePrice;
	}
	
	public String getePublishDate() {
		return ePublishDate;
	}
	
	public String getePublisher() {
		return ePublisher;
	}
	
	public String geteTitle() {
		return eTitle;
	}
	
	public String geteAge() {
		return eAge;
	}
	
	public String geteCountry() {
		return eCountry;
	}
	
	public String editdb(){
		String url = "jdbc:mysql://localhost:3306/BookDB";
		String username = "root";
		String password = "******";
		Connection con_edit = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con_edit = DriverManager.getConnection(url, username, password);
			String sql = "select * from Author where Name=?";
			if(!eAuthorName.equals("")){
				PreparedStatement ecauthor_library = con_edit.prepareStatement(sql);
				ecauthor_library.setString(1, eAuthorName);
				ResultSet ecauthor_data =  ecauthor_library.executeQuery();
				if(ecauthor_data.next()){
					String AuthorID = ecauthor_data.getString("AuthorID");
					if(!ePublisher.equals("") && !ePublishDate.equals("") && !ePrice.equals("") && !eTitle.equals("")){
						me = SUCCESS;
						sql = "update Book set AuthorID=?,Publisher=?,PublishDate=?,Price=? where Title=?";
						PreparedStatement ebook_library = con_edit.prepareStatement(sql);
						ebook_library.setInt(1, Integer.parseInt(AuthorID));
						ebook_library.setString(2, ePublisher);
						ebook_library.setString(3, ePublishDate);
						ebook_library.setString(4, ePrice);
						ebook_library.setString(5, eTitle);
						ebook_library.executeUpdate();
					}
					else{
						me = INPUT_ERROR;
					}
				}
				else{
					if(!eAge.equals("") && !eCountry.equals("")){
						sql="insert into Author (Name,Age,Country) values (?,?,?)";
						PreparedStatement eauthor_library = con_edit.prepareStatement(sql);
						eauthor_library.setString(1, eAuthorName);
						eauthor_library.setInt(2, Integer.parseInt(eAge));
						eauthor_library.setString(3, eCountry);
						eauthor_library.executeUpdate();
						sql = "select * from Author where Name=?";
						PreparedStatement esearch_author_library = con_edit.prepareStatement(sql);
						esearch_author_library.setString(1, eAuthorName);
						ResultSet esearch_author_data =  esearch_author_library.executeQuery();
						if(esearch_author_data.next()){
							if(!ePublisher.equals("") && !ePublishDate.equals("") && !ePrice.equals("") && !eTitle.equals("")){								me = SUCCESS;
								sql = "update Book set AuthorID=?,Publisher=?,PublishDate=?,Price=? where Title=?";
								PreparedStatement edit_book_library = con_edit.prepareStatement(sql);
								String AuthorID = esearch_author_data.getString("AuthorID");
								edit_book_library.setInt(1, Integer.parseInt(AuthorID));
								edit_book_library.setString(2, ePublisher);
								edit_book_library.setString(3, ePublishDate);
								edit_book_library.setString(4, ePrice);
								edit_book_library.setString(5, eTitle);
								edit_book_library.executeUpdate();
							}
							else{
								me = INPUT_ERROR;
							}
						}
					}
					else{
						me = INPUT_ERROR;
					}
				}
			}
			else{
				me = INPUT_ERROR;
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("数据库连接失败！");
			me = ERROR;
			e.printStackTrace();
		}	
		catch(SQLException e){
			System.out.println("操作失误！");
			me = ERROR;
			e.printStackTrace();
		}	
		catch(NumberFormatException e){
			System.out.println("输入不能为空！");
			me = "input_error";
			e.printStackTrace();
		}	
		finally {
			if(con_edit != null){
				try{
					con_edit.close();
				}
				catch(SQLException e){
					me = ERROR;
					e.printStackTrace();
				}
			}
		}
		
		return me;
	}
}
