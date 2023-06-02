package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory{

	public static HikariDataSource hds=null;
	
	static
	{
		try {
			FileReader fr = new FileReader("C:\\java\\advancedPractise\\jdbc.property");
			Properties p=new Properties();
			p.load(fr);
			
			HikariConfig hc=new HikariConfig();
			hc.setJdbcUrl(p.getProperty("DB_URL"));
            hc.setUsername(p.getProperty("DB_USERNAME"));
            hc.setPassword(p.getProperty("DB_PWD"));
            hc.setMaximumPoolSize(Integer.parseInt(p.getProperty("DB_MAXPOOL")));
			hc.setMinimumIdle(Integer.parseInt(p.getProperty("DB_MINIDLE")));
			
	        hds=new HikariDataSource(hc);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static Connection getConnection() throws Exception
	{
		return hds.getConnection();
	}
}
