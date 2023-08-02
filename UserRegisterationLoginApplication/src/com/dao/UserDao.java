package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.User;
import com.util.ConnectionFactory;

public class UserDao {

	public User getUserInfo(User user)
	{
		User oldUser=new User();
		Connection con;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from User where email=? and password=?");
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPwd());

			ResultSet eq = pstmt.executeQuery();
			if(eq.next())
			{
				oldUser.setFirstName(eq.getString(1));
				oldUser.setLastName(eq.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oldUser;
	}
}
