package com;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetExample {

	public static void main(String[] args) {

		try {
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/advjava");
			rowSet.setUsername("vaibhav");
			rowSet.setPassword("vaibhav");
			
			rowSet.setCommand("select * from books");
			
			rowSet.execute();
			while(rowSet.next())
			{
				System.out.print(rowSet.getInt(1)+"\t");
				System.out.print(rowSet.getString(2)+"\t");
				System.out.println(rowSet.getDouble(3));
			}
			rowSet.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
