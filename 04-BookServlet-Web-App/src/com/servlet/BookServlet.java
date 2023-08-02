package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BooksDAO;
import com.dto.Book;

@WebServlet("/bookservlet")
public class BookServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
	     String BookId=req.getParameter("bookId");
	     String BookName=req.getParameter("bookName");
	     String BookPrice=req.getParameter("bookPrice");
	     
	     PrintWriter writer = res.getWriter();
	     /*writer.append("<h1>Book Id is : "+BookId+"</h1>");
	     writer.append("<h1>Book Name is : "+BookName+"</h1>");
	     writer.append("<h1>Book Price is : "+BookPrice+"</h1>");*/
	     Book book=new Book();
	     book.setBookId(Integer.parseInt(BookId));
	     book.setBookName(BookName);
	     book.setBookPrice(Integer.parseInt(BookPrice));
	     BooksDAO bookdao=new BooksDAO();
	     Boolean saveBookData = bookdao.saveBookData(book);
	     if(saveBookData)
	     {
	    	 writer.append("<h1>Record inserted successfully</h1>");
	     }
	     else
	     {
             writer.append("<h1>Record insertion failed.</h1>");	    	 
	     }
	}
}
