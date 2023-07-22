package com.servlet;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookservlet")
public class book extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
	     String BookId=req.getParameter("bookId");
	     String BookName=req.getParameter("bookName");
	     String BookPrice=req.getParameter("bookPrice");
	     
	     PrintWriter writer = res.getWriter();
	     /*writer.append("<h1>Book Id is : "+BookId+"</h1>");
	     writer.append("<h1>Book Name is : "+BookName+"</h1>");
	     writer.append("<h1>Book Price is : "+BookPrice+"</h1>");*/
	     
	     try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader file=new FileReader("C:\\java\\advancedpractise\\jdbc.property");
			Properties prop=new Properties();
			prop.load(file);
			Connection con = DriverManager.getConnection(prop.getProperty("DB_URL"),prop.getProperty("DB_USERNAME"),prop.getProperty("DB_PWD"));
			PreparedStatement pstmt=con.prepareStatement("insert into books values(?,?,?)");
			pstmt.setInt(1, Integer.parseInt(BookId));
			pstmt.setString(2,BookName);
			pstmt.setInt(3,Integer.parseInt(BookPrice));
			
			int extupdate = pstmt.executeUpdate();
			if(extupdate!=0)
			{
				writer.append("<h1>Record inserted successfully</h1>");
			}
			else
			{
			    writer.append("<h1>Record insertion failed.</h1>");	
			}
			con.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	}
	
}
