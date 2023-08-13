package com.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	public static HikariDataSource hsc=null;
	
	public static Connection getConnection() throws SQLException
	{
		if(null==hsc)
		{
			try
			{
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
				
				hsc=new HikariDataSource(hc);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return hsc.getConnection();
	}
	
}
