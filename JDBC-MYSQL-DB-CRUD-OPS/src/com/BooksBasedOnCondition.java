package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class BooksBasedOnCondition {

	public static void main(String[] args) {

		try {
			FileReader fr=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			PreparedStatement ps=con.prepareStatement("select * from books where book_price<=?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter book price : ");
			int bookPrice=sc.nextInt();
			ps.setInt(1, bookPrice);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3));
			}
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
