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

public class ResultSetMetaData {

	public static void main(String[] args) {
try {
			
			FileReader fr=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("SELECT * FROM BOOKS");
			
			java.sql.ResultSetMetaData metaData = rs.getMetaData();
			
			System.out.println(metaData.getColumnCount());
			System.out.println(metaData.getColumnName(1)+" - "+metaData.getColumnName(2)+" - "+metaData.getColumnName(3));
			
			con.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		};

	}

}
