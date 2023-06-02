package com;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class RetrieveBook {

	public static void main(String[] args) {

		try {
			FileReader fr=new FileReader("C:\\Java\\AdvancedPractise\\jdbc.property");
		    Properties p=new Properties();
		    p.load(fr);

		    //Step-1 : Load Driver
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    
		    //Step-2 : Get Connection
		    Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
		
		    //Step-3 : Prepare Statement
		    Statement st=con.createStatement();
		    
		    //Step-4 : Execute Query
		    ResultSet rs=st.executeQuery("SELECT * FROM BOOKS");
		    
		    //Step-5 : Retrieve Result
		    while(rs.next())
		    {
		    	System.out.println(rs.getInt("BOOK_ID")+" - "+rs.getString("BOOK_NAME")+" - "+rs.getInt("BOOK_PRICE"));
		    }
		    
		    //Step-6 : Close 
		    
		    
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
