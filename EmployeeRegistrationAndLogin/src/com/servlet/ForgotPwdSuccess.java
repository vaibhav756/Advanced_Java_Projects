package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserMasterDAO;
import com.dto.UserDTO;

@WebServlet("/forgotpwdsuccess")
public class ForgotPwdSuccess extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserDTO dto=new UserDTO();
		dto.setEmail(req.getParameter("email"));
		dto.setPwd(req.getParameter("newpassword"));
		UserMasterDAO dao=new UserMasterDAO();
		Boolean result = dao.updatePassword(dto);
		String msg="";
		if(result)
		{
			msg="Forgot password successfully.";
			req.setAttribute("msg",msg);
			req.getRequestDispatcher("ForgotPwdSuccess.jsp").forward(req, res);
		}
		else
		{
			msg="Forgot password failed.";
			req.setAttribute("msg",msg);
			req.getRequestDispatcher("ForgotPwdSuccess.jsp").forward(req, res);
		}
		
	}
	
}
