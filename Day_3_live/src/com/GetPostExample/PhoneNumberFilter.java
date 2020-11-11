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
 * Servlet Filter implementation class PhoneNumberFilter
 */
@WebFilter("/PhoneNumberFilter")
public class PhoneNumberFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PhoneNumberFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Phone number filter");
		HttpServletRequest rs=(HttpServletRequest) request;
		String phone=rs.getParameter("phone");
		if(!phone.isEmpty() && phone.length()==10 && phone.matches("[0-9]+")) {
			chain.doFilter(rs, response);

		}else {
			RequestDispatcher rd=rs.getRequestDispatcher("error.html");
			rd.forward(rs, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	public static boolean containsAnyChar(String phone) {
		char[] ch=phone.toCharArray();
		for(char c : ch) {
			Character.isAlphabetic(c);
			return true;
		}
		return false;
	}
}
