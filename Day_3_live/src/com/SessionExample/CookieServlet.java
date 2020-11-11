package com.SessionExample;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SESSIONID_COOKIE="sessionId";
	private static final String USERNAME_COOKIE="userName";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		boolean cookieFound=false;
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(SESSIONID_COOKIE)) {
					cookieFound=true;
					response.getWriter().append("<html><body><h3>User : "+request.getParameter("userName")
					+ " is already logged in with seesion id : "+cookie.getValue() 
					+ "</h3></body></html>");
					break;
				}	
			}
		}
		if(cookieFound==false) {
			Cookie sessionCookie=new Cookie(SESSIONID_COOKIE, LocalDateTime.now().toString());
			Cookie  userNameCookie=new Cookie(USERNAME_COOKIE, request.getParameter("userName"));
			response.addCookie(sessionCookie);
			response.addCookie(userNameCookie);
			response.getWriter().append("Served at : "+request.getContextPath());

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
