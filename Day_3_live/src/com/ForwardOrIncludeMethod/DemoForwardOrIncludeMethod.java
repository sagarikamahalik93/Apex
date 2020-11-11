package com.ForwardOrIncludeMethod;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoForwardOrIncludeMethod
 */
@WebServlet("/DemoForwardOrIncludeMethod")
public class DemoForwardOrIncludeMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoForwardOrIncludeMethod() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		//String n=request.getParameter("userName");  
		String p=request.getParameter("userPass");  

		if(p.equals("pass")){  
			RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
			rd.forward(request, response);  
		}  
		else{  
			out.print("Sorry UserName or Password Error!");  
			RequestDispatcher rd=request.getRequestDispatcher("/error.html");  
			rd.include(request, response);  

		}  
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
