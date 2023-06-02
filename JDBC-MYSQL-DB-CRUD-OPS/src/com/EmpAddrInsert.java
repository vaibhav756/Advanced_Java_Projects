package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpAddrInsert {

	private static final String DB_URL="jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME="vaibhav";
	private static final String DB_PWD="vaibhav";		
	private static final String EMP_INS="insert into employee(empId,empName,empSal) values(?,?,?)";
	private static final String ADDR_INS="insert into addressss values(?,?,?,?)";
	
	public static void main(String[] args) throws SQLException{
		Connection con=DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		try {
			con.setAutoCommit(false);
			
			PreparedStatement ps=con.prepareStatement(EMP_INS);
			ps.setInt(1, 103);
			ps.setString(2,"Rohan Vele");
			ps.setDouble(3,15000.00);
			
			ps.executeUpdate();
			
			ps=con.prepareStatement(ADDR_INS);
			ps.setString(1,"Banglore");
			ps.setString(2,"Maharashtra");
			ps.setString(3,"India");
			ps.setInt(4, 103);
			
			ps.executeUpdate();
			System.out.println("Records inserted...");
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("Transaction RolledBack");
			con.rollback();
			e.printStackTrace();
		}
		
		con.close();

	}

}
