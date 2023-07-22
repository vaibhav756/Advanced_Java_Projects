package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CallableStatementClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		try {
			Properties prop=new Properties();	
			FileReader file=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			prop.load(file);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(prop.getProperty("DB_URL"),prop.getProperty("DB_USERNAME"),prop.getProperty("DB_PWD"));
			CallableStatement call=con.prepareCall("call getBookInfo()");
			ResultSet rs = call.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3));
			}
			con.close();
			call.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
