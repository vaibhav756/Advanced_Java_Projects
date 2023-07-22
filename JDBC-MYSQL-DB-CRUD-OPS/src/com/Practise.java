package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Practise {

	public static void main(String[] args) {

		try {
             FileReader fr=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			 Properties prop=new Properties();
			 prop.load(fr);
			 
			Driver drive=new Driver(); 
			Connection con = DriverManager.getConnection(prop.getProperty("DB_URL"),prop.getProperty("DB_USERNAME"),prop.getProperty("DB_PWD"));
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter UserId : ");
			Integer id=sc.nextInt();
			System.out.println("Enter UserName : ");			
			String name=sc.next();
						
			PreparedStatement ps=con.prepareStatement("select * from Books");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3));
			}
			con.close();
			ps.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
