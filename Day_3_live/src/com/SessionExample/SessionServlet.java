package com.SessionExample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SESSION_ATTRIBUTE="sessionAttribute";
	private static final String GET_ATTRIBUTE="getAttribute";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession reqSession=request.getSession(true);
		String sessionId=reqSession.getId();
		reqSession.setAttribute(SESSION_ATTRIBUTE, "value-1");
		String val1=(String) reqSession.getAttribute(SESSION_ATTRIBUTE);
		response.getWriter().write(String.format("<html><h2>"
				+ "Session Id : %s%n. Session Attribute : %s"
				+ "</h2></html>", sessionId, val1));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession reqSession=request.getSession(true);
		String sessionId=reqSession.getId();
		String val1=(String) reqSession.getAttribute(SESSION_ATTRIBUTE);
		String val2=(String) reqSession.getAttribute(GET_ATTRIBUTE);
		response.getWriter().write(String.format("<html><body><h2>"
				+ "Session Id : %s%n. Session Attribute : %s. Get Attribute is : %s"
				+ "</h2></body></html>", sessionId, val1,val2));
	}
}
