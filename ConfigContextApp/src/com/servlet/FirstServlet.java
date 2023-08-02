package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.Context;

public class FirstServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		 PrintWriter writer = res.getWriter();
		 ServletConfig config=getServletConfig();
		 String msg = config.getInitParameter("msg");
		 writer.append("<h1>"+msg+"</h1>");
		 ServletContext contextPath = req.getServletContext();
		 String initParameter = contextPath.getInitParameter("ApplictionName");
		 writer.append(initParameter);
	}
}
