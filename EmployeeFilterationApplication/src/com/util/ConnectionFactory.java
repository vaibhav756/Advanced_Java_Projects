package com.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	private static HikariDataSource hds=null;
	
	public static Connection getConnection() throws SQLException
	{
		if(hds==null)
		{
			try {
				Properties prop=new Properties();
				FileReader file=new FileReader("C:\\java\\advancedPractise\\jdbc.property");
				prop.load(file);
				
				HikariConfig hc=new HikariConfig();
				hc.setDriverClassName("com.mysql.cj.jdbc.Driver");
				hc.setJdbcUrl(prop.getProperty("DB_URL"));
				hc.setUsername(prop.getProperty("DB_USERNAME"));
				hc.setPassword(prop.getProperty("DB_PWD"));
				hc.setMaximumPoolSize(Integer.parseInt(prop.getProperty("DB_MAXPOOL")));
				hc.setMinimumIdle(Integer.parseInt(prop.getProperty("DB_MINIDLE")));
				
				
				hds=new HikariDataSource(hc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return hds.getConnection();
	}

}
