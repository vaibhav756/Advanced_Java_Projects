package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter writer = res.getWriter();
		ServletConfig conf = getServletConfig();
		String initParameter = conf.getInitParameter("msg");
		writer.append(initParameter);
		ServletContext context = req.getServletContext();
		String initParam = context.getInitParameter("ApplictionName");
		writer.append(initParam);
	}
	
}
