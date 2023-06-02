package com;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class RegisterAndLogin {

	public static void main(String[] args) throws IOException {
		
		try
		{
		FileReader fr=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
        Properties p=new Properties();
        p.load(fr);
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Press 1 for Registration and 2 for Login");
        int val=sc.nextInt();
        boolean enteredVal=true;
        String email="";
        String password="";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
        Statement st=con.createStatement();
			while (enteredVal) {
				if (val == 1) {
				   System.out.println("Enter UserEmail");
				   email=sc.nextLine();
				   System.out.println("Enter Password");
				   password=sc.nextLine();
                   int result=st.executeUpdate("Insert into employee values("+email+","+password+")");
                   if(result>0)
                   System.out.println("User Register Successfully");
                   else
                   System.out.println("User doesn't Register Successfully");
				} else if (val == 2) {

				} else {
					System.out.println("Wrong value entered");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
