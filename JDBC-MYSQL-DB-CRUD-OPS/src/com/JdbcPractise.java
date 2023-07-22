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

import com.mysql.cj.jdbc.Driver;

public class JdbcPractise {

	public static void main(String[] args) {
		
		try {

			Properties prop=new Properties();
			FileReader file=new FileReader("C:\\java\\advancedPractise\\jdbc.property");
			prop.load(file);
			
			Driver driver=new Driver();
			Connection con = DriverManager.getConnection(prop.getProperty("DB_URL"),prop.getProperty("DB_USERNAME"),prop.getProperty("DB_PWD"));
			PreparedStatement ps=con.prepareStatement("select * from Books where book_price<=?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter BookPrice : ");
			Integer bookPrice=sc.nextInt();
			System.out.println(bookPrice);
			ps.setInt(1, bookPrice);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3));
			}
			con.close();
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
