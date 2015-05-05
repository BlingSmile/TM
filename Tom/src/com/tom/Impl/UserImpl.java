package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.Config;
import Utils.DBUtil;

import com.tom.Dao.UserDao;

public class UserImpl implements UserDao{

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
	ResultSet rs = null;
	
	@Override
	public int Register(String phone, String password, int activecode) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		try {
			sql = "insert into User(phone,password) values("
					+ "?,?)" ;
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2,password);
			result = psmt.executeUpdate();
			
			if(result>0) {
				int Uid;
				sql = "select Uid from User where phone = '"+phone+"'";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				rs.next();
				Uid = rs.getInt("Uid");
				
				sql = "insert into Setting(Uid) values ("+Uid+")";
				psmt = conn.prepareStatement(sql);
				result = psmt.executeUpdate();
				
				if(result > 0)
					result = Config.SUCCESS;
				else 
					result = Config.FAILE;
			}
			else
				result = Config.FAILE;
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return result;
	}

	@Override
	public int GetActivecode(String phone) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		
		//判断电话是否已经被注册
		sql = "select Uid from User where phone  = '"+ phone +"'";
		
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next())
				result = Config.USER_EXIST;
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	
	@Override
	public int Login(String phone, String psw) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		String password;
		sql = "select password from User where phone = '" + phone + "'";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(!rs.next())
				result = Config.PHONE_NOT_EXIST;
			else 
			{
				password = rs.getString("password");
				if(psw.equals(password))
					result = Config.SUCCESS;
				else
					result = Config.WRONG_PSW;
					
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public ResultSet GetFocus(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select user.Uid,username from user,focusu where user.Uid = focusu.Uid and focusu.Uid = "+userId;
		System.out.println(sql);
		return null;
	}

}
