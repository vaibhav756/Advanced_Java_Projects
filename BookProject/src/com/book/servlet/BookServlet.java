package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDAO;
import com.book.dto.Book;
@WebServlet("/bookservlet")
public class BookServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		Book book=new Book();
		book.setBookId(Integer.parseInt(req.getParameter("bookId")));
		book.setBookName(req.getParameter("bookName"));
		book.setBookPrice(Integer.parseInt(req.getParameter("bookPrice")));
		
		BookDAO dao=new BookDAO();
		Boolean saveBook=false;
		try {
			saveBook = dao.saveBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer = res.getWriter();
		if(saveBook)
		writer.append("<h1>Record inserted successfully.</h1>");
		else
		writer.append("<h1>Record insertion failed.</h1>");
	}
}
