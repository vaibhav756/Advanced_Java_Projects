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

public class EmpInnerJoinDetailsWithEmpId {

	private static final String getEmpData="select * from employee e inner join address a on e.empId=a.empId where e.empId=?";
	
	public static void main(String[] args) {

		try {
			FileReader fr=new FileReader("C:\\java\\advancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			PreparedStatement ps=con.prepareStatement(getEmpData);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter empId : ");
			int empId=sc.nextInt();
			ps.setInt(1, empId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getDouble(3)+" - "+rs.getString(4)+" - "+rs.getString(5)+" - "+rs.getString(6)+" - "+rs.getString(7)+" - "+rs.getString(8)+" - "+rs.getString(9)+" - "+rs.getInt(10));
			}
			con.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
