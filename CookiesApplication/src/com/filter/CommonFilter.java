package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebFilter("/CommonFilter")
public class CommonFilter extends HttpFilter implements Filter {
     
	private static Integer count=0; 
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		count++;
		PrintWriter writer = response.getWriter();
		writer.append("Visitor count : "+count);
		chain.doFilter(request, response);
	}
}
