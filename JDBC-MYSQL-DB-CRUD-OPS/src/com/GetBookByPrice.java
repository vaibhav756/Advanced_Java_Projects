package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import java.util.Scanner;

public class GetBookByPrice {

	public static void main(String[] args) {
        try {
			FileReader fr=new FileReader("C:\\java\\advancedpractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			CallableStatement cs=con.prepareCall("call getBookNameByBookPrice(?,?)");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter book price : ");
			int bookPrice=sc.nextInt();
			cs.setInt(1, bookPrice);
			cs.registerOutParameter(2, Types.VARCHAR);
			ResultSet rs=cs.executeQuery();
			
			while(rs.next())
			{
				System.out.println("BookName with price "+bookPrice+" is "+rs.getString(1));
			}
			con.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
