package com.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateUser {
	public static boolean checkUser(String uname, String pass) {
		boolean st=true;
		DAO.setUpConnection();
		try {
			PreparedStatement ps=DAO.con.prepareStatement("select * from user where uname=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			st=rs.next();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}