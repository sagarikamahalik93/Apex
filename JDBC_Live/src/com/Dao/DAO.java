package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public static Connection con;
	public static void setUpConnection(){
		System.out.println("Connection Setup");
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbname = "apex_live";
		String username = "root";
		String password = "system";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + dbname, username, password);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
