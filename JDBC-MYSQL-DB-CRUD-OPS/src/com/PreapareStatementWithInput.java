package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class PreapareStatementWithInput {

	public static void main(String[] args) {

		try {
			FileReader fr=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			PreparedStatement ps=con.prepareStatement("insert into books values(?,?,?)");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter book id : ");
			int bookId=sc.nextInt();
			System.out.println("Enter book name : ");
			String bookName=sc.next();
			System.out.println("Enter book price : ");
			int bookPrice=sc.nextInt();
			
			ps.setInt(1, bookId);
			ps.setString(2, bookName);
			ps.setInt(3, bookPrice);
			
			int val=ps.executeUpdate();
			if(val>0)
			System.out.println("No of record updated : "+val);
			else
			System.out.println("No record updated...");
			
            con.close();			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e)
		{
			e.printStackTrace();
		} catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}
