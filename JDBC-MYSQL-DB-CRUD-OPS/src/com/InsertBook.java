package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertBook {

	private static final String DB_URL="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USERNAME="vaibhav";
	private static final String DB_PWD="vaibhav";
	private static String InsertQuery="INSERT INTO BOOKS VALUES(114,'Spring',7000)";
	
	public static void main(String[] args)throws Exception {

		try {
			//Step-1: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step-2: Get Database connection
			Connection con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PWD);
			
			//Step-3: Create Statement
            Statement st=con.createStatement();		
            
            //Step-4: Execute Query
            int rowsEffected = st.executeUpdate(InsertQuery);
            
            //Step-5: Process Result
            if(rowsEffected!=0)
            System.out.println("Record inserted count : "+rowsEffected);
            else
        	System.out.println("Record not inserted");	
			
            //Step-6: Close Connection
            con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
