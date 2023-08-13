package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.append("First servlet executed.");
		writer.append("<form action=\"second\" >");
		writer.append("<input type=\"hidden\" name=\"uname\" value=\"Raju\" />");
		writer.append("<input type=\"submit\" value=\"Submit\" />");
		writer.append("</form>");
	}
}
