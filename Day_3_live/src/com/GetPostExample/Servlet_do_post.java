package com.GetPostExample;

import java.io.IOException;

//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_do_post")
public class Servlet_do_post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_do_post() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    //PrintWriter out = response.getWriter();  
	          
	    //String n=request.getParameter("userName");  
	    
	    RequestDispatcher rd=request.getRequestDispatcher("Success.html");
	    rd.include(request, response);
	    } 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
//	    out.print("Welcome "+n);
//	    out.print("<html><body><p>Welcome : "+n+"</p><button>logout</button></body></html>");
	}
}
