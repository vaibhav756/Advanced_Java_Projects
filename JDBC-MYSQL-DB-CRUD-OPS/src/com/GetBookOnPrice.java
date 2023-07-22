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

public class GetBookOnPrice {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		try {
			FileReader file=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			Properties prop=new Properties();
			prop.load(file);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(prop.getProperty("DB_URL"),prop.getProperty("DB_USERNAME"),prop.getProperty("DB_PWD"));
			PreparedStatement ps = con.prepareStatement("select * from Books where book_price<=?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter salary : ");
			Integer sal=sc.nextInt();
			ps.setInt(1, sal);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3));
			}
			con.close();
			ps.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}

}
