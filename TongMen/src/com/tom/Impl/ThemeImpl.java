package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Utils.Config;
import Utils.DBUtil;

import com.tom.Dao.ThemeDao;

public class ThemeImpl implements ThemeDao{

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
	ResultSet rs = null;
	
	@Override
	public ResultSet GetPubTheme(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select Tid,Cid,Ttitle,Tdate from theme where Uid = "+userId;
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	
	@Override
	public int CreateTheme(int circleId, int Uid, String title, String content) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "insert into theme(Cid,Uid,Ttitle,Tcontent,Tdate) values (?,?,?,?,?)";
		System.out.println(sql);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, circleId);
			psmt.setInt(2,Uid);
			psmt.setString(3,title);
			psmt.setString(4,content);
			psmt.setTimestamp(5, new Timestamp(new Date().getTime()));
			result = psmt.executeUpdate();
			System.out.println(result);
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
	public ResultSet GetTmemeLisi(int circleId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "insert into theme(Cid,Uid,Ttitle,Tcontent,Tdate) values (?,?,?,?,?)";
		System.out.println(sql);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, circleId);
			psmt.setTimestamp(5, new Timestamp(new Date().getTime()));
			result = psmt.executeUpdate();
			System.out.println(result);
			if(result > 0)
				result = Config.SUCCESS;
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
