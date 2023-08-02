package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dto.UserDTO;

@WebServlet("/user")
public class UserServlet extends HttpServlet{

	//Get UserList
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserDAO dao=new UserDAO();
		List<UserDTO> users = dao.findAllUser();
		req.setAttribute("users", users);
		req.getRequestDispatcher("AllUsers.jsp").forward(req,res);
	}
	
	//Add User
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserDTO dto=new UserDTO();
		dto.setUserName(req.getParameter("username"));
		dto.setUserEmail(req.getParameter("useremail"));
		dto.setUserPhno(Long.parseLong(req.getParameter("userphno")));
		
		UserDAO dao=new UserDAO();
		Boolean saveUser = dao.saveUser(dto);
		String msg=null;
		if(saveUser)
		msg="User saved";
		else
		msg="User not saved";
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/index.jsp").forward(req, res);
		
	}
	
}
