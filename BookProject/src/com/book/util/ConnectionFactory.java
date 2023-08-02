package com.book.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static HikariDataSource hds=null;
	
	public static Connection getConnection() throws SQLException
	{
		try
		{
			if(hds==null)
			{
				Properties prop=new Properties();
				FileReader file=new FileReader("C:\\java\\advancedpractise\\jdbc.property");
				prop.load(file);
				
				HikariConfig conf=new HikariConfig();
				conf.setJdbcUrl(prop.getProperty("DB_URL"));
				conf.setUsername(prop.getProperty("DB_USERNAME"));
				conf.setPassword(prop.getProperty("DB_PWD"));
				conf.setMaximumPoolSize(Integer.parseInt(prop.getProperty("DB_MAXPOOL")));
				conf.setMinimumIdle(Integer.parseInt(prop.getProperty("DB_MINIDLE")));
				
				hds=new HikariDataSource(conf);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hds.getConnection();
	}
	
}
