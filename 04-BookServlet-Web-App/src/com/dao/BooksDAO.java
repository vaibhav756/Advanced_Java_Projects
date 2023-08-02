package com.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.dto.Book;

public class BooksDAO {

	public Boolean saveBookData(Book book) throws IOException
	{
		
		Boolean result=false;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader file=new FileReader("C:\\java\\advancedpractise\\jdbc.property");
			Properties prop=new Properties();
			prop.load(file);
			Connection con = DriverManager.getConnection(prop.getProperty("DB_URL"),prop.getProperty("DB_USERNAME"),prop.getProperty("DB_PWD"));
			PreparedStatement pstmt=con.prepareStatement("insert into books values(?,?,?)");
			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2,book.getBookName());
			pstmt.setInt(3,book.getBookPrice());
			
			int extupdate = pstmt.executeUpdate();
			if(extupdate!=0)
			{
                 result=true;
			}
			con.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
	}
	
}
