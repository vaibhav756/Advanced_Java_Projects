package com;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class OperationUsingPropertyClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
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
		int result=st.executeUpdate("INSERT INTO BOOKS VALUES(104,'Spring Boot',10000)");
		
		//Step-5 : Retrieve Result
		if(result>0)
		System.out.println("Record inserted count : "+result);
		else
		System.out.println("No record inserted");
		
		//Step-6 : Close connection
		con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
