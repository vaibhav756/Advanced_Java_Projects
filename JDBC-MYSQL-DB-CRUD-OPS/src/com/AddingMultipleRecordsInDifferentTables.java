package com;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class AddingMultipleRecordsInDifferentTables {

	private static final String insertEmp="insert into employee(empId,empName,empSal) values(?,?,?)";
	private static final String insertAddr="insert into address values(?,?,?,?)";
	
	public static void main(String[] args)throws Exception {

		FileReader fr=new FileReader("C:\\java\\advancedpractise\\jdbc.property");
        Properties p=new Properties();
        p.load(fr);
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PWD"));
        
        PreparedStatement ps=con.prepareStatement(insertEmp);
        ps.setInt(1, 101);
        ps.setString(2, "Vaibhav Yadav");
        ps.setDouble(3, 12000.00);
        
        ps.executeUpdate();
        
        ps=con.prepareStatement(insertAddr);
        
        ps.setString(1,"Mumbai");
        ps.setString(2,"Maharashtra");
        ps.setString(3,"India");
        ps.setInt(4,101);
       
        ps.executeUpdate();
		con.close();
	}

}
