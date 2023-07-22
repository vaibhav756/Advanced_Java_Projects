package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
	     String name = req.getParameter("username");
	     PrintWriter writer = res.getWriter();
	     writer.append("<h1>Welcome "+name+"</h1>");
	}
	
}
