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

public class SalaryBonusForEmployees {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("C:\\java\\advancedpractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);			
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter hike percentage : ");
			Double hike=sc.nextDouble();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			StringBuilder query=new StringBuilder("update employee set empSal=(empSal+((empSal*?)/100))");
            PreparedStatement ps=con.prepareStatement(query.toString());
            ps.setDouble(1, hike);
            int val=ps.executeUpdate();
            if(val>0)
            {
            	System.out.println("Rows effected : "+val);
            }
			con.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
