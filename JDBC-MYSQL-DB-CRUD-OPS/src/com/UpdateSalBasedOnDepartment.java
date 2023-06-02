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

public class UpdateSalBasedOnDepartment {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("C:\\java\\advancedpractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
            Class.forName("com.mysql.cj.jdbc.Driver");			
            Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter hike for CTO");
            Double ctoHike=sc.nextDouble();
            
            System.out.println("Enter hike for CDO");
            Double cdoHike=sc.nextDouble();
            
            System.out.println("Enter hike for CEO");
            Double ceoHike=sc.nextDouble();
            
            StringBuilder selectQuery=new StringBuilder("Select * from employee");
            PreparedStatement ps=con.prepareStatement(selectQuery.toString());
            
            StringBuilder updateQuery=new StringBuilder("update employee set empSal=(empSal+(empSal*?)/100) where empDept=?");
            
            PreparedStatement psupdate=con.prepareStatement(updateQuery.toString());
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            	if("CTO".equals(rs.getString(4)))
            	{
            		psupdate.setDouble(1, ctoHike);
            		psupdate.setString(2,"CTO");
            	}
            	else if("CDO".equals(rs.getString(4)))
            	{
            		psupdate.setDouble(1, cdoHike);            		
            		psupdate.setString(2,"CDO");
            	}
            	else
            	{
            		psupdate.setDouble(1, ceoHike);
            		psupdate.setString(2,"CEO");
            	}
            	psupdate.executeUpdate();
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
