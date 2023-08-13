package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/second")
public class SecondServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter writer = res.getWriter();
		Cookie[] cookies = req.getCookies();
		if(cookies!=null)
		{
			for(Cookie c:cookies)
			{
				writer.append("Welcome : "+c.getValue());
			}
		}
		else
		{
			writer.append("Invalid request.");			
		}
	}
	
}
