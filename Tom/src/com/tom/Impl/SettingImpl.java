package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.Config;
import Utils.DBUtil;

import com.tom.Dao.SettingDao;

public class SettingImpl implements SettingDao{

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = Config.FAILE;
	ResultSet rs = null;
	
	@Override
	public int CloseAllowMessage(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		
		//判断电话是否已经被注册
		sql = "update setting set allowText = 0 where Uid = "+userId;
		
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
			
			if(result > 0)
				result = Config.SUCCESS;
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int OpenAllowMessage(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		
		//判断电话是否已经被注册
		sql = "update setting set allowText = 1 where Uid = "+userId;
		
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
			
			if(result > 0)
				result = Config.SUCCESS;
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int CloseAllowInvite(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		
		//判断电话是否已经被注册
		sql = "update setting set allowInvite = 0 where Uid = "+userId;
		
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
			
			if(result > 0)
				result = Config.SUCCESS;
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int OpenAllowInvite(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		
		//判断电话是否已经被注册
		sql = "update setting set allowInvite = 1 where Uid = "+userId;
		
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
			
			if(result > 0)
				result = Config.SUCCESS;
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int GetMessageStatu(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		
		//判断电话是否已经被注册
		sql = "select allowText from setting where Uid = "+userId;
		
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt("allowText");
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int GetInviteStatu(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		
		//判断电话是否已经被注册
		sql = "select allowInvite from setting where Uid = "+userId;
		
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt("allowInvite");
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
