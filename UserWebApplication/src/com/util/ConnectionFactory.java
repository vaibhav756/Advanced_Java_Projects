package com.util;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	public static HikariDataSource hds=null;
	
	public static Connection getConnection() throws SQLException
	{
		if(hds==null)
		{
			try
			{
				Properties prop=new Properties();
				prop.load(new FileReader(new File("C:\\java\\advancedPractise\\jdbc.property")));
				
				HikariConfig conf=new HikariConfig();
				conf.setJdbcUrl(prop.getProperty("DB_URL"));
				conf.setUsername(prop.getProperty("DB_USERNAME"));
				conf.setPassword(prop.getProperty("DB_PWD"));
				conf.setDriverClassName("com.mysql.cj.jdbc.Driver");
				conf.setMaximumPoolSize(Integer.parseInt(prop.getProperty("DB_MAXPOOL")));
				conf.setMinimumIdle(Integer.parseInt(prop.getProperty("DB_MINIDLE")));
				hds=new HikariDataSource(conf);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return hds.getConnection();
	}
	
}
