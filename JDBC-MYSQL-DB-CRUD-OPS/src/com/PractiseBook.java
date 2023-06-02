package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PractiseBook {

	public static void main(String[] args) {	
		
		try {
		
			FileReader fr=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			
			//Preapare Statement
			Statement st=con.createStatement();
			
			//Execute Update
			int result=st.executeUpdate("Insert into books values(105,'React',6000)");
			
			if(result>0)
		    System.out.println("Inserted successfully count : "+result);
			else
			System.out.println("No data inserted");
			
			//Close connection
			con.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}
}
