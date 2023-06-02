package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	public static void main(String[] args) {
	
		FileReader fr;
		try {
			fr = new FileReader("C:\\java\\advancedpractise\\jdbc.property");
	        Properties p=new Properties();
	        p.load(fr);
			HikariConfig hc = new HikariConfig();
			hc.setJdbcUrl(p.getProperty("DB_URL"));
			hc.setUsername(p.getProperty("DB_USERNAME"));
			hc.setPassword(p.getProperty("DB_PWD"));		
	        hc.setMaximumPoolSize(20);
	        hc.setMinimumIdle(5);
	        
	        HikariDataSource hds=new HikariDataSource(hc);
	        Connection con = hds.getConnection();
	        System.out.println(con);
	        
/*	        String rec1="insert into address values('Mumbai','Maharashtra','India',103)";
	        Statement createStatement = con.createStatement();
	        int executeUpdate = createStatement.executeUpdate(rec1);
	        System.out.println("No of records inserted : "+executeUpdate);*/
	        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
	}
}
