package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.UserDTO;
import com.util.ConnectionFactory;

public class UserDAO {
	
	private static final String INSERT_SQL="insert into registeruser(user_name,user_email,user_phno) values(?,?,?)";
	private static final String SELECT_SQL="select * from registeruser";
	private static final String SELECT_SQL_USING_ID="select * from registeruser where user_id=?";
	
	//Save User
	public Boolean saveUser(UserDTO user)
	{
		int result=0;
		try
		{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pstmt=con.prepareStatement(INSERT_SQL);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setLong(3, user.getUserPhno());
			
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result>0;
	}
	
	//FindAll User
	public List<UserDTO> findAllUser()
	{
		List<UserDTO> userList=new ArrayList<>();
		try
		{
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet result = st.executeQuery(SELECT_SQL);
			
			while(result.next())
			{
				UserDTO user=new UserDTO();
				user.setUserId(result.getInt(1));
				user.setUserName(result.getString(2));
				user.setUserEmail(result.getString(3));
				user.setUserPhno(result.getLong(4));
				userList.add(user);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
	}
	
	
	//Find User using userId
    public UserDTO findByUserId(String userId) throws SQLException
    {
    	UserDTO user=new UserDTO();
    	try {
    	Connection con=ConnectionFactory.getConnection();
    	PreparedStatement pstmt = con.prepareStatement(SELECT_SQL_USING_ID);
    	pstmt.setInt(1, Integer.parseInt(userId));
    	ResultSet result = pstmt.executeQuery();
    	while(result.next())
    	{
    		user.setUserId(result.getInt(1));
    		user.setUserName(result.getString(2));
    		user.setUserEmail(result.getString(3));
    		user.setUserPhno(result.getLong(4));
    	}
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return user;
    }
	
	
}
