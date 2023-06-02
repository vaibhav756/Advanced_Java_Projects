package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FindEmployeeBasedOnHireDate {

	private static String url="jdbc:mysql://localhost:3306/vaibhav";
	private static String username="vaibhav";
	private static String pwd="vaibhav";
	
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwd);
			PreparedStatement ps=con.prepareStatement("select * from emp where hiredate between ? and ?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter first date : ");
			String firstDate=sc.nextLine();
			System.out.println("Enter second date : ");
			String secondDate=sc.nextLine();
			
			ps.setString(1, firstDate);
			ps.setString(2, secondDate);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2));
			}
			
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
