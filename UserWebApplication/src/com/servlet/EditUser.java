package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dto.UserDTO;

@WebServlet("/edituser")
public class EditUser extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String userId = req.getParameter("userid");
		UserDAO dao=new UserDAO();
		UserDTO user=new UserDTO();
		try {
			user = dao.findByUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("user", user);
		req.getRequestDispatcher("index.jsp").forward(req, res);
		
	}
	
}
