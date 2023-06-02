package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class getBookData {

	public static void main(String[] args) {
		
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from books");
			while(rs.next())
			{
		         System.out.println(rs.getInt(1)+" - "+rs.getString(1)+" - "+rs.getDouble(3));		
			}
			con.close();
			st.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
