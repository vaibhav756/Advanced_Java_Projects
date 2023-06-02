package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PreaparedStatementClass {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("C:\\java\\AdvancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
			PreparedStatement ps=con.prepareStatement("insert into books values(?,?,?)");
			ps.setInt(1,106);
			ps.setString(2, "React");
			ps.setInt(3, 75000);
			
			int val=ps.executeUpdate();
			if(val>0)
			System.out.println("No of rows updated : "+val);
			else
			System.out.println("No record updated");
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
