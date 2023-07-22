package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
	    PrintWriter writer = res.getWriter();
	    writer.append("<h1>Message class executed.</h1>");
	}
	
}
