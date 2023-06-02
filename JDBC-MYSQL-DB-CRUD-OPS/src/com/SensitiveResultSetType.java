package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SensitiveResultSetType {

	public static void main(String[] args) {
		
		try {
			FileReader fr=new FileReader("C:\\Java\\AdvancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet result = st.executeQuery("SELECT * FROM BOOKS");
			
			result.absolute(3);
			
			System.out.println(result.getInt(1)+" - "+result.getString(2)+" - "+result.getInt(3));
			
			result.updateInt(3,15000);
			result.updateRow();
			
			result.previous();
			
			System.out.println(result.getInt(1)+" - "+result.getString(2)+" - "+result.getInt(3));
			
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
