package com.GetPostExample;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class UserNameFilter2
 */
@WebFilter("/UserNameFilter2")
public class UserNameFilter2 implements Filter {

	/**
	 * Default constructor. 
	 */
	public UserNameFilter2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("User name filter");
		HttpServletRequest req=(HttpServletRequest) request;
		String firstname=req.getParameter("firstName");
		if(!firstname.isEmpty() && !containsDigit(firstname) && firstname.matches("[a-zA-Z]+")) {
			chain.doFilter(req, response);

		}else {
			RequestDispatcher rd=req.getRequestDispatcher("error.html");
			rd.forward(req, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	public static boolean containsDigit(String str) {
		char[] c=str.toCharArray();
		for(char ch:c) {
			if(Character.isDigit(ch)) {
				return true;
			}
		}
		return false;
	}
}
