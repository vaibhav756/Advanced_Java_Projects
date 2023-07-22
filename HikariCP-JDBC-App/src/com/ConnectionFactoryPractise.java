package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactoryPractise {

	public static void main(String[] args) throws IOException, SQLException {
		try {
			FileReader file=new FileReader("C:\\java\\advancedpractise\\jdbc.property");
			Properties prop=new Properties();
			prop.load(file);
			
			HikariConfig hc=new HikariConfig();
			hc.setJdbcUrl(prop.getProperty("DB_URL"));
			hc.setUsername(prop.getProperty("DB_USERNAME"));
			hc.setPassword(prop.getProperty("DB_PWD"));
			hc.setMaximumPoolSize(20);
			hc.setMinimumIdle(5);
			
			
			HikariDataSource hds=new HikariDataSource(hc);
			
			Connection con=hds.getConnection();
			
			System.out.println(con);
			con.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
		
		
	}
}
