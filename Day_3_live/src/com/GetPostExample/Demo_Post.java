package com.GetPostExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo_Post
 */
@WebServlet("/Demo_Post")
public class Demo_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Demo_Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		//String n=request.getParameter("userName");  
		String p=request.getParameter("userPass");  

		if(p.equals("pass")){  
			RequestDispatcher rd=request.getRequestDispatcher("servlet_do_post");  
			rd.forward(request, response);  
		}  
		else{  
			out.print("Sorry UserName or Password Error!");  
			RequestDispatcher rd=request.getRequestDispatcher("/error.html");  
			rd.include(request, response);  

		}  
	}

}
