package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBUtil;

import com.tom.Dao.UserDao;

public class UserImpl implements UserDao{

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
	ResultSet rs = null;
	
	@Override
	public boolean Register(int phone, String password, int activecode) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		sql = "insert into User(phone,password) values("
				+ "?,?)" ;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, phone);
			psmt.setString(2,password);
			
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		if (result > 0)
			return true;
		else
			return false;
	}

}
