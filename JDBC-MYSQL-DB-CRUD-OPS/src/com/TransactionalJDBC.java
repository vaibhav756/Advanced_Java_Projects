package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TransactionalJDBC {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		Properties prop=new Properties();	
		FileReader file;
		try {
			file = new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			prop.load(file);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(prop.getProperty("DB_URL"),prop.getProperty("DB_USERNAME"),prop.getProperty("DB_PWD"));
            con.setAutoCommit(false);
            
            Statement st=con.createStatement();
            int update = st.executeUpdate("update Books set book_price=1500 where book_id=115");
			int execute = st.executeUpdate("update Booooks set book_price=4500 where book_id=450");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
