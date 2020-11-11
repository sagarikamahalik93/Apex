package com.Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Dao.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		DAO.setUpConnection();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		response.setContentType("text/html;charset=UTF-8");
		String uname=request.getParameter("uname");
		String password=request.getParameter("psw");
		String fullname=null;
		if(ValidateUser.checkUser(uname, password)) {
			try {
				PreparedStatement ps=DAO.con.prepareStatement("select * from user where uname=? and password=?");
				ps.setString(1, uname);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					fullname=rs.getString(3);
				}
				if(session!=null) {
					request.setAttribute("fullname", fullname);
				}
				System.out.println(fullname);
				RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
				rd.forward(request, response);
				ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
