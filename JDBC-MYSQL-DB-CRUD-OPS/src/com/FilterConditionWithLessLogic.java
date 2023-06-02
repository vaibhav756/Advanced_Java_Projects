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

public class FilterConditionWithLessLogic {

	public static void main(String[] args) {

		try {
			FileReader fr=new FileReader("C:\\java\\advancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			StringBuilder sb=new StringBuilder("select * from employee where 1=1 ");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Location :");
            String loc=sc.nextLine();
            
            System.out.println("Enter Department");
            String dept=sc.nextLine();
            
			System.out.println("Enter Gender");
            String gender=sc.nextLine();
            
            if(!"".equals(loc))
            {
            	sb.append("and workLoc=?");
            }
            if(!"".equals(dept))
            {
            	sb.append("and empDept=?");
            }
            if(!"".equals(gender))
            {
            	sb.append("and empGen=?");
            }
            System.out.println(sb.toString());
            
            PreparedStatement ps=con.prepareStatement(sb.toString());
            int index=1;
            if(!"".equals(loc))
            {
                ps.setString(index,loc);
                index++;
            }
            if(!"".equals(dept))
            {
                ps.setString(index, dept);
                index++;
            }
            if(!"".equals(gender))
            {
                ps.setString(index, gender);
            }
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            	System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3)+" - "+rs.getString(4)+" - "+rs.getString(5)+" - "+rs.getString(6));
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
