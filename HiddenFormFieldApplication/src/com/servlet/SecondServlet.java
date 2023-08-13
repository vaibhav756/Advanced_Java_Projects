package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter writer = res.getWriter();
		String uname = req.getParameter("uname");
		if(null!=uname)
		{
			writer.append("Welcome : "+uname);
		}
		else
		{
			writer.append("Invalid request");
		}
	}
}