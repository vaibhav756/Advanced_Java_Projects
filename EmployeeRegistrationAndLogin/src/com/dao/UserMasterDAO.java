package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.UserDTO;
import com.util.ConnectionFactory;

public class UserMasterDAO {

	public static final String INSERT_USER="insert into user_master(fname,lname,email,pwd,gender) values(?,?,?,?,?)";
	
	public static final String FIND_USER="select * from user_master where email=? and pwd=?";
	
	public static final String FIND_BY_EMAIL="select * from user_master where email=?";
	
	public static final String UPDATE_PWD="update user_master set pwd=? where email=?";
	
	public Boolean saveUser(UserDTO user) throws SQLException
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(INSERT_USER);
		pstmt.setString(1, user.getFname());
		pstmt.setString(2, user.getLname());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getPwd());
		pstmt.setString(5, user.getGender());
		
		int result = pstmt.executeUpdate();
		return result>0;
	}
	
	public String getUser(UserDTO user)
	{
		String result=null;
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pstmt=con.prepareStatement(FIND_USER);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPwd());
			
			ResultSet resultset = pstmt.executeQuery();
			while(resultset.next())
			{
				result=resultset.getString(2)+" "+resultset.getString(3);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public String getUserByEmail(UserDTO dto)
	{
		String result=null;
		try
		{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_EMAIL);
			pstmt.setString(1,dto.getEmail());
			ResultSet resultset = pstmt.executeQuery();
			while(resultset.next())
			{
				result=resultset.getString(4);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public Boolean updatePassword(UserDTO dto)
	{
		int result=0;
		try
		{
		    Connection con=ConnectionFactory.getConnection();
		    PreparedStatement pstmt = con.prepareStatement(UPDATE_PWD);
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getEmail());
			result = pstmt.executeUpdate();			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result>0;
	}
	
}
