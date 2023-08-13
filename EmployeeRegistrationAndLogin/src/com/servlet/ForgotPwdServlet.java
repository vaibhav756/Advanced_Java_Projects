package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserMasterDAO;
import com.dto.UserDTO;

@WebServlet("/forgotpwd")
public class ForgotPwdServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("ForgotPwd.jsp").forward(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserDTO dto=new UserDTO();
		dto.setEmail(req.getParameter("email"));
		UserMasterDAO dao=new UserMasterDAO();
		String email = dao.getUserByEmail(dto);
		if(email!=null)
		{
			req.setAttribute("email", email);
			req.getRequestDispatcher("ForgotPwdSuccess.jsp").forward(req, res);
		}
		else
		{
			email="Invalid Email";
			req.setAttribute("email", email);
			req.getRequestDispatcher("ForgotPwd.jsp").forward(req, res);
		}
	}
	
}
