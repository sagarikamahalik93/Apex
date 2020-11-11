package com.Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DAO;

@WebServlet("/ServletConnectivity")
public class ServletConnectivity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConnectivity() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		DAO.setUpConnection();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/ShowUserDetails.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		try {
			PreparedStatement ps = DAO.con.prepareStatement("insert into user (uname,password,fullname) values (?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, password);
			ps.setString(3, fullname);

			int noOfRecords = ps.executeUpdate();
			//PrintWriter out = response.getWriter();
			System.out.println(noOfRecords + " record inserted successfully..");
			String result=noOfRecords + " record inserted successfully..";
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("/Success.jsp");
			rd.include(request, response);
			ps.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
