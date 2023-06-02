package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBook {

	private static final String DB_URL="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USERNAME="vaibhav";
	private static final String DB_PWD="vaibhav";
	
	public static void main(String[] args) {
	
		try {
			//Step-1 : Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step-2 : Get Connection
			Connection con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PWD);
			
            //Step-3 : Prepare Statement
			Statement st=con.createStatement();
			
			//Step-4 : Execute Qeury
			int record=st.executeUpdate("UPDATE BOOKS SET BOOK_ID=104,BOOK_NAME='SPRING BOOT',BOOK_PRICE=10000 where BOOK_ID=103");
			
			//Step-5 : Retrieve result
			if(record>0)
				System.out.println("Record updated count : "+record);
			else
				System.out.println("Record not updated");
			
			//Step-6 : Close connection
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
