package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.Config;
import Utils.DBUtil;

import com.mysql.jdbc.Statement;
import com.tom.Dao.CircleDao;

public class CircleImpl implements CircleDao {

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
     ResultSet rs = null;
	
     //创建圈子
	public int CreateCircle(int Uid,String Cname,String Cdesc){
		conn = DBUtil.getConnection();
		//sql="select Cname FROM Circle";
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
	
	//根据用户id获取关注的圈子
	public ResultSet getCidByUid(int Uid){
        conn=DBUtil.getConnection();
		
		try {
			sql = "select Cname,Cdesc FROM circle,focusc where circle.Cid=focusc.Cid and focusc.Uid="+Uid;
			System.out.println("根据Uid获得圈子"+Uid);
			psmt = conn.prepareStatement(sql);
			//psmt.setInt(1, Uid);			
			
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
	
	//展示圈子资料
	public ResultSet showCircle(int Cid){
		 conn=DBUtil.getConnection();
		 try{
		 sql = "select Cname，Cdesc FROM Circle Where circle.Cid= "+Cid;
		 System.out.println("根据圈子id"+Cid+"获取圈子信息");
			psmt = conn.prepareStatement(sql);						
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	public ResultSet showCircleResource(int Cid){
		 conn=DBUtil.getConnection();
		 try{
		 sql = "select Rid Rtitle,Rcontent,Rlink FROM Resource,Circle Where circle.Uid=resource.Uid and resource.Cid= "+Cid;
		 System.out.println("根据圈子id"+Cid+"获取圈子信息");
			psmt = conn.prepareStatement(sql);						
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
}
