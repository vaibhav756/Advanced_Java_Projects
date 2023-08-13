package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dto.EmployeeDTO;

@WebServlet("/empservlet")
public class EmpServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEmpName(req.getParameter("empname"));
		dto.setEmpEmail(req.getParameter("empemail"));
		dto.setEmpGender(req.getParameter("empgender"));
		dto.setEmpDept(req.getParameter("empdept"));
		dto.setEmpExp(Integer.parseInt(req.getParameter("empexp")));
		
		EmployeeDAO dao=new EmployeeDAO();
		Boolean result=false;
		try {
			result = dao.saveEmployee(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String msg="";
		if(result)
		msg="Employee inserted sucessfully";
		else
		msg="Employee insertion failed";
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("index.jsp").forward(req,res);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		EmployeeDAO dao=new EmployeeDAO();
		EmployeeDTO dto=new EmployeeDTO();
		if(req.getParameter("empdept")!="")
		dto.setEmpDept(req.getParameter("empdept"));
		dto.setEmpGender(req.getParameter("empgender"));
		if(null!=req.getParameter("empexp"))
		{
			if(Integer.parseInt(req.getParameter("empexp"))!=0)
			dto.setEmpExp(Integer.parseInt(req.getParameter("empexp")));			
		}
		List<EmployeeDTO> emps=new ArrayList<>();
		try {
			emps = dao.getEmployee(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("emps", emps);
		req.getRequestDispatcher("AllEmployees.jsp").forward(req, res);
	}
	
}
