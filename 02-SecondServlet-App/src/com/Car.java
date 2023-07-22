package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/car")
public class Car extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		try {
			
			System.out.println(request.getHeaderNames());
			System.out.println(request.getRequestedSessionId());
			//System.out.println();
			PrintWriter writer = response.getWriter();
			writer.append("<h1>Car is running...</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
