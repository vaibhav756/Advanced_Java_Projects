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

public class FilterBasedOnCondtion {

	public static void main(String[] args) {
		
		try {
			FileReader fr=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			StringBuilder query=new StringBuilder("select * from Employee ");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Work Location");
			String loc=sc.nextLine();
			if(!("".equals(loc)))
			{
				query.append("where workLoc=?");
			}
			System.out.println("Enter Department");
			String dept=sc.nextLine();
			if(!("".equals(dept)) && !("".equals(loc)))
			{
				query.append("and empDept=?");
			}
			else if(!("".equals(dept)))
			{
				query.append("where empDept=?");
			}
			System.out.println("Enter Gender");
			String gender=sc.nextLine();
			if((!"".equals(gender) && (!"".equals(dept)) && (!"".equals(loc))) || ((!"".equals(gender)) && (!"".equals(dept))) || ((!"".equals(gender)) && (!"".equals(loc))))
			{
				query.append("and empGen=?");
			}
			else if(!"".equals(gender))
			{
				query.append("where empGen=?");
			}
			PreparedStatement ps=con.prepareStatement(query.toString());
			
			if((!"".equals(loc)))
			{
				ps.setString(1,loc);
			}
			if((!"".equals(loc)) && (!"".equals(dept)))
			{
				ps.setString(2,dept);
			}
			else if((!"".equals(dept)))
			{
				ps.setString(1,dept);
			}
			if((!"".equals(gender)) && (!"".equals(dept)) && (!"".equals(loc)))
			{
				ps.setString(3,gender);
			}
			else if(((!"".equals(gender)) && (!"".equals(dept))) || ((!"".equals(gender)) && (!"".equals(loc))))
			{
				ps.setString(2,gender);
			}
			else if((!"".equals(gender)))
			{
				ps.setString(1,gender);
			}
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getString(4)+" - "+rs.getString(5)+" - "+rs.getString(6));
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
