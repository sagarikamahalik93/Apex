package com.HitCounter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitCounter2
 */
@WebFilter("/HitCounter2")
public class HitCounter2 implements Filter {
	private int hitCount;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitCounter2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(FilterConfig config) throws ServletException {
    	hitCount=0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		hitCount++;
		System.out.println("Site counter : "+hitCount);
		chain.doFilter(request, response);
	}
}
