package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class BatchOperationUsingPrepareStatement {

	public static void main(String[] args) throws Exception {
		
		try {
			FileReader fr = new FileReader("C:\\JAVA\\ADVANCEDPRACTISE\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			PreparedStatement ps=con.prepareStatement("insert into books values(111,'1st std',200)");
			ps.addBatch("insert into books values(112,'2nd std',300)");
			ps.addBatch("insert into books values(113,'3rd std',400)");
			
			int val[]=ps.executeBatch();
			if(val.length>0)
			System.out.println("Number of record inserted : "+val.length);
			else
			System.out.println("No record inserted...");
			
			con.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}

}
