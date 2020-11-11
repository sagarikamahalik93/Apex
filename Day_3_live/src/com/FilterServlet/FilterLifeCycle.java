package com.FilterServlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/FilterLifeCycle")
public class FilterLifeCycle implements Filter {
       
    public FilterLifeCycle() {
        System.out.println("Filter.filter()");
    }

    public void destroy() {
		System.out.println("Filter.destroy()");
	}
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, javax.servlet.ServletException { 
    	System.out.println("Filter.doFilter()");
    	chain.doFilter(request, response);
    }
	
	public void init(FilterConfig filterConfig) throws javax.servlet.ServletException { 
    	System.out.println("Filter.init()");
    }
}
