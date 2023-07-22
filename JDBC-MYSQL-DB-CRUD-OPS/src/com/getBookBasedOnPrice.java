package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class getBookBasedOnPrice {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		try {
			FileReader file=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			Properties prop=new Properties();
			prop.load(file);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(prop.getProperty("DB_URL"),prop.getProperty("DB_USERNAME"),prop.getProperty("DB_PWD"));
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter salary amount ");
			Integer sal=sc.nextInt();
			CallableStatement call=con.prepareCall("call getBooksLessThanPrice(?)");
			call.setInt(1, sal);
			ResultSet rs = call.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3));
			}
			con.close();
			call.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		

	}

}
