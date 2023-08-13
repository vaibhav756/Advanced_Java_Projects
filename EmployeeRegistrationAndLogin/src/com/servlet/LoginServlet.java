package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserMasterDAO;
import com.dto.UserDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
	    req.getRequestDispatcher("Login.jsp").forward(req, res);	
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserDTO dto=new UserDTO();
		dto.setEmail(req.getParameter("email"));
		dto.setPwd(req.getParameter("password"));
		
		UserMasterDAO dao=new UserMasterDAO();
		String user = dao.getUser(dto);
		if(null!=user)
		{
			HttpSession session=req.getSession();
			session.setAttribute("uname",user);
			user="Welcome "+user;
			req.setAttribute("msg", user);		
			req.getRequestDispatcher("Dashboard.jsp").forward(req,res);
		}
		else
		{
			user="Invalid UserName and Password";
			req.setAttribute("msg",user);
			req.getRequestDispatcher("Login.jsp").forward(req, res);			
		}
	}
}
