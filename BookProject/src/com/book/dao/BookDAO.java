package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.book.dto.Book;
import com.book.util.ConnectionFactory;

public class BookDAO {

	public static final String INSERT_SQL="insert into Books values(?,?,?)";
	
	public Boolean saveBook(Book book) throws SQLException, ClassNotFoundException
	{
		int executeUpdate=0;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(INSERT_SQL);
		pstmt.setInt(1, book.getBookId());
		pstmt.setString(2, book.getBookName());
		pstmt.setInt(3, book.getBookPrice());
		
		executeUpdate = pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return executeUpdate>0;
	}
	
}
