package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		HttpSession session = req.getSession(false);
		String uname="";
		if(null!=session)
		{
			session.setMaxInactiveInterval(5000);
			Enumeration<String> attributeNames = session.getAttributeNames();
			while(attributeNames.hasMoreElements())
			{
				System.out.println(attributeNames.nextElement()+" - "+session.getId());
			}
			uname = (String)session.getAttribute("uname");			
		}
		PrintWriter writer = res.getWriter();
		if(null!=uname && uname!="")
		{
			writer.append("Welcome : "+uname);
			writer.append("<form action=\"logout\">");
			writer.append("<button type=\"submit\">Submit</button>");
			writer.append("</form>");
			//session.invalidate();
		}
		else
		{
			writer.append("Invalid request");			
		}

	}
	
}
