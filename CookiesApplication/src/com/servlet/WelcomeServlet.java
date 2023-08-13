package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		 Cookie cookie=new Cookie("email","yvaibhav756@gmail.com");
		 res.addCookie(cookie);
         PrintWriter writer = res.getWriter();
         writer.append("First servlet executed.");
	}
}
