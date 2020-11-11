package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		DAO.setUpConnection();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		try {
			if(uname=="admin") {
				PrintWriter out = response.getWriter();
				out.println("<html><body><h3>" + uname + " can't be deleted..</h3></body></html>");
			}else {
				PreparedStatement ps = DAO.con.prepareStatement("delete from user where uname=?");
				ps.setString(1, uname);
				int deletedRecord = ps.executeUpdate();
				System.out.println(deletedRecord + " record deleted successfully..");
				String result=deletedRecord + " record deleted successfully..";
				request.setAttribute("result", result);
				RequestDispatcher rd = request.getRequestDispatcher("/Success.jsp");
				rd.include(request, response);
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
