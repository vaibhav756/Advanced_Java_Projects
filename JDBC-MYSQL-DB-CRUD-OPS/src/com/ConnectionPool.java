package com;

import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {

	public static HikariDataSource hdc=null;
	
	static {
		
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
			
			hdc=new HikariDataSource(hc);
            			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception
	{
		return hdc.getConnection();
	}

}
