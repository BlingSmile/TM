package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.Config;
import Utils.DBUtil;

import com.tom.Dao.CircleDao;

public class CircleImpl implements CircleDao {

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
    ResultSet rs = null;
	
	public int CreateCircle(int Uid,String Cname,String Cdesc){
		conn = DBUtil.getConnection();
		sql = "insert into Circle(Uid,Cname,Cdesc) values("
				+ "?,?,?)" ;			
					
		try{ 
		            psmt = conn.prepareStatement(sql);
					psmt.setInt(1, Uid);
					psmt.setString(2,Cname);
					psmt.setString(3,Cdesc);
					result = psmt.executeUpdate();
					conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				if(result > 0)
					result = Config.SUCCESS;
				else 
					result = Config.FAILE;								  		
		return result;
	}
	
	public ResultSet getCidByUid(int Uid){
        conn=DBUtil.getConnection();
		
		try {
			sql = "select Cname,Cdesc FROM circle,focusc where circle.Cid=focusc.Cid and focusc.Uid="+Uid;
			psmt = conn.prepareStatement(sql);			
			
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
	
	public ResultSet showCircle(int Cid){
		 conn=DBUtil.getConnection();
		 try{
		 sql = "select Cname,Cdesc FROM Circle Where circle.Cid= "+Cid;
			psmt = conn.prepareStatement(sql);						
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
}
