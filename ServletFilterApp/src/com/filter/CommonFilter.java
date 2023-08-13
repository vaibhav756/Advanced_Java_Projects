package com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class CommonFilter
 */
@WebFilter("/*")
public class CommonFilter extends HttpFilter implements Filter {
    
	private static Integer count=0;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter writer = response.getWriter();
		count++;
		writer.append("request no : "+count+"<br>");
		if(LocalTime.now().getHour()>=9 && LocalTime.now().getHour()<=18)
		{
			chain.doFilter(request, response);			
		}
		else
		{
			writer.append("System is closed.Kindly try tomorrow after 9am.");
		}

	}
}
