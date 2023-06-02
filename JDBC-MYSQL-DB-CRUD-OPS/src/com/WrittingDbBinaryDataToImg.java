package com;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WrittingDbBinaryDataToImg {

	public static void main(String[] args) {

		try {
			Connection con=ConnectionPool.getConnection();
			PreparedStatement st=con.prepareStatement("select * from person where person_name=?");
			st.setString(1,"Rohan Vele");
			ResultSet rs=st.executeQuery();
			
			while(rs.next())
			{
			byte[] imgByte=rs.getBytes(2);
			FileOutputStream fos=new FileOutputStream("C:\\JAVA\\dbimg.jpg");
			fos.write(imgByte);
			}
			rs.close();
			con.close();
			System.out.println("Image converted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
