package com.tom.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.Config;
import Utils.DBUtil;

import com.tom.Dao.ResourceDao;

public  class ResourceImpl implements ResourceDao{

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
	ResultSet rs = null;
	
	//上传资料
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
	
	public int AddResourcePraise(int Rid,int Uid,int Pid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "update Resource set Rpraise = Rpraise+1 where Rid = "+Rid;
		System.out.println(sql);
		try {
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
			
			sql = "update user set praise = praise+1 where Uid = "+Uid;
			psmt = conn.prepareStatement(sql); 
			result = psmt.executeUpdate();
			
			sql = "insert into praise(Rid,Uid,Pid,Ptype) values(?,?,?,?)";
			psmt = conn.prepareStatement(sql); 
			psmt.setInt(1, Rid);
			psmt.setInt(2, Uid);
			psmt.setInt(3, Pid);
			psmt.setInt(4, 1);
			result = psmt.executeUpdate();
			
			if(result == 0)
				result = Config.FAILE;
			else
				result = Config.SUCCESS;
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public ResultSet GetPubRec(int userId) {
		// TODO Auto-generated method stub
		System.out.println(userId);
		conn = DBUtil.getConnection(); 
		sql = "select Rid,Cid,Rtitle,Rdate from resource where Uid = "+userId;
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
	
	public ResultSet showCircleResource(int Rid){
		 conn=DBUtil.getConnection();
		 try{
		 sql = "select Rtitle,Rcontent,Rlink FROM Resource Where resource.Rid= "+Rid;
		// System.out.println("");
			psmt = conn.prepareStatement(sql);						
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

	public boolean deleteResource(int Uid,int Rid) {
		// TODO Auto-generated method stub
		boolean flag=  false;
		conn = DBUtil.getConnection();
		String sql = "delete from Resoruce where Uid=? and Rid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Uid);
			psmt.setInt(1, Rid);
			result = psmt.executeUpdate();
			if(result>0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public ResultSet SerchByRid(int Rid) {
		// TODO Auto-generated method stub
		conn=DBUtil.getConnection();
		
		try {
			sql = "select * from Resource Where resource.Rid= "+Rid;
			System.out.println("根据资料id查询"+sql);
			
			psmt = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = psmt.executeQuery();
			rs.next();
			System.out.println(rs.getString(4));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet SerchByUid(int Uid) {
		// TODO Auto-generated method stub
		conn=DBUtil.getConnection();
		
		try {
			sql = "select * from Resource Where resourceUid= "+Uid;
			System.out.println("根据上传人Id查询"+sql);
			
			psmt = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = psmt.executeQuery();
			rs.next();
			System.out.println(rs.getString(4));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}
