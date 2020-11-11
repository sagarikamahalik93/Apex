package com.Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DAO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String newname = request.getParameter("newname");
		try {
			PreparedStatement ps = DAO.con.prepareStatement("update user set uname=? where uname=?");
			ps.setString(1, newname);
			ps.setString(2, uname);
			int updatedRecord = ps.executeUpdate();
			//PrintWriter out = response.getWriter();
			System.out.println(updatedRecord + " record updated successfully..");
			String result=updatedRecord + " record updated successfully..";
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("/Success.jsp");
			rd.include(request, response);
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
