package com.tom.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import Utils.Config;
import Utils.DBUtil;

import com.tom.Dao.ResourceDao;

public class ResourceImpl implements ResourceDao {
	private static final String Rdata = null;
	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
	ResultSet rs = null;
	
	public int UploadResource(int Cid,int Uid,String Rtitle,String Rcontent,Date Rdata,String Rlink){
		conn = DBUtil.getConnection();
		sql = "insert into Resource(Cid,Uid,Rtitle,Rcontent,Rdate,Rlink) values("
				+ "?,?,?,?,?,?)" ;	
		
		 try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Cid);
			psmt.setInt(2, Uid);
			psmt.setString(3,Rtitle);
			psmt.setString(4,Rcontent);
			psmt.setDate(5,Rdata);
			psmt.setString(6,Rlink);
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
	
	public void addPraise(int Uid) {
		// TODO Auto-generated method stub
		
		conn=DBUtil.getConnection();
		
		try {
			sql = "update menu set praise = praise + 1 where Uid = "+Uid;
			
			psmt = conn.prepareStatement(sql);
			
			int i = psmt.executeUpdate();
			
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
