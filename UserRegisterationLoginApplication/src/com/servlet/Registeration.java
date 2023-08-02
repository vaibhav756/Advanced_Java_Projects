package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Registeration extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter writer = res.getWriter();
		writer.append("<h6>Enter FirstName : </h1><input type='text' name='firstname'></input><br>");
		writer.append("<h1>Enter LastName : </h1><input type='text' name='lastname'></input>");
		writer.append("<h1>Enter Email : </h1><input type='text' name='email'></input>");
		writer.append("<h1>Enter Password : </h1><input type='text' name='password'></input>");
		writer.append("<h1>Enter Gender : </h1><input type='text' name='gender'></input>");
		
	}
}
