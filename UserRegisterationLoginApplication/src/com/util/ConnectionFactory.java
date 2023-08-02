package com.util;

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
		try {
			    if(hds==null)
			    {
					HikariConfig hc=new HikariConfig();
					Properties prop=new Properties();
					prop.load(new FileReader("C:\\java\\advancedpractise\\jdbc.property"));
					hc.setJdbcUrl(prop.getProperty("DB_URL"));
					hc.setUsername(prop.getProperty("DB_USERNAME"));
					hc.setPassword(prop.getProperty("DB_PWD"));
					hc.setDriverClassName("com.mysql.cj.jdbc.Driver");
					hds=new HikariDataSource(hc);
			    }

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	    return hds.getConnection();
	}	
}
