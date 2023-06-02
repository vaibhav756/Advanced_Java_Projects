package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteBook {

	private static final String DB_URL="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USERNAME="vaibhav";
	private static final String DB_PWD="vaibhav";
	private static final String DeleteQuery="DELETE FROM BOOKS WHERE BOOK_ID=104";
	
	public static void main(String[] args) {
		try {
			//Step-1 : Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step-2 : Get connection
			Connection con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PWD);
			
			//Step-3 : Preapare Statement
			Statement st=con.createStatement();
			
			//Step-4 : Execute Query
			int result=st.executeUpdate(DeleteQuery);
			
			//Step-5 : Retrieve Result
			if(result>0)
			System.out.println("Record deleted count : "+result);
			else
			System.out.println("No record deleted");
			
			//Step-6 : Close connection
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
