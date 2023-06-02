package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class InsertingImageDataInDB {

	public static void main(String[] args) {
		try {
			File f=new File("C:\\Java\\PersonPic.jpg");
			FileInputStream fis=new FileInputStream(f);
			
			FileReader fr=new FileReader("C:\\JAVA\\ADVANCEDPRACTISE\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			PreparedStatement pt=con.prepareStatement("insert into person values(?,?)");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter person name : ");
			String name=sc.nextLine();
			
			pt.setString(1,name);
			pt.setBlob(2, fis);
			
			int val=pt.executeUpdate();
			if(val>0)
			System.out.println("Inserted record count : "+val);
			else
			System.out.println("No record inserted");
			
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
