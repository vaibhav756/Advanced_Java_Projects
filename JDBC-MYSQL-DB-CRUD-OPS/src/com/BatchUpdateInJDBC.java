package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class BatchUpdateInJDBC {

	public static void main(String[] args) throws Exception {

		try {
			FileReader fr=new FileReader("C:\\JAVA\\ADVANCEDPRACTISE\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			Statement st=con.createStatement();
			st.addBatch("insert into books values(108,'JavaScript',2500)");
			st.addBatch("insert into books values(109,'TypeScript',4000)");
			st.addBatch("insert into books values(110,'NodeJS',5000)");
			
			int values[]=st.executeBatch();
			for(int val:values)
			{
				System.out.println(val);
			}
			con.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
