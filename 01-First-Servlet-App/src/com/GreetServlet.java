package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet{

	public void doGet(HttpServletRequest hsreq,HttpServletResponse hsres) throws IOException
	{
		PrintWriter writer = hsres.getWriter();
		writer.append("<h1>Greeting from Java Develepers</h1>");
	}
	
}
