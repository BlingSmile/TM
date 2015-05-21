package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBUtil;

import com.tom.Dao.PromoteDao;

public class PromoteImpl implements PromoteDao{
	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
	ResultSet rs = null;
	
	public ResultSet PromoteTheme(){
		conn=DBUtil.getConnection();
		try {
			sql = "select * FROM theme  ORDER BY Tpraise desc";
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return rs;		
	}
	public ResultSet PromoteCircle(){
		conn=DBUtil.getConnection();
		try {
			sql = "select * FROM circle,resource where circle.Cid=resource.Cid  ORDER BY Rpraise desc";
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return rs;		
	}
	public ResultSet PromoteUser(){
		conn=DBUtil.getConnection();
		try {
			sql = "select * FROM user where user.level>4 ORDER BY praise desc";
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return rs;		
	}
}
