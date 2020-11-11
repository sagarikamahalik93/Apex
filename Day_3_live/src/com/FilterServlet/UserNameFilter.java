package com.FilterServlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/UserNameFilter")
public class UserNameFilter implements Filter {
	
    public UserNameFilter() {
     
    }

    public void init(FilterConfig filterConfig) throws ServletException { 
    
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { 
    	System.out.println("Entered UserNameFilter ");
    	chain.doFilter(request, response);
    	System.out.println("Exited UserNameFilter");
    }
	
	public void destroy() {
		
	}
}
