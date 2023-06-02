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

public class ProcedureCallExample {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("C:\\java\\advancedpractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
	        Class.forName("com.mysql.cj.jdbc.Driver");			
	        Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));

	        String procedureName="call getBooksData()";
	        CallableStatement prepareCall = con.prepareCall(procedureName);
            ResultSet rs = prepareCall.executeQuery();
	        while(rs.next())
	        {
	        	System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3));
	        }
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
