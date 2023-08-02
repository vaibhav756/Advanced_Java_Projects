package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dto.User;
@WebServlet("/login")
public class Login extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		User user=new User();
		user.setEmail(req.getParameter("email"));
		user.setPwd(req.getParameter("password"));
		
        UserDao dao=new UserDao();
        User userInfo = dao.getUserInfo(user);
		PrintWriter writer = res.getWriter();
		if(null!=userInfo.getFirstName())
		{
			writer.append("<h1>Welcome to our application "+userInfo.getFirstName()+" "+userInfo.getLastName()+"</h1>");
		}else
		{
			writer.append("<h1>Invalid UserName & Password</h1>");
		}
	}
}
