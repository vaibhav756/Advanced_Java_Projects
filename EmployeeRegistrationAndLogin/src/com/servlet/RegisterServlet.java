package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserMasterDAO;
import com.dto.UserDTO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
         req.getRequestDispatcher("Register.jsp").forward(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserDTO user=new UserDTO();
		user.setFname(req.getParameter("fname"));
		user.setLname(req.getParameter("lname"));
		user.setEmail(req.getParameter("email"));
		user.setPwd(req.getParameter("password"));
		user.setGender(req.getParameter("gender"));
		
		UserMasterDAO dao=new UserMasterDAO();
		Boolean result=false;
		try {
			result = dao.saveUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String msg="";
		if(result)
		msg="User register success";
		else
		msg="User register failed";
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("Register.jsp").forward(req, res);
	}
	
}
