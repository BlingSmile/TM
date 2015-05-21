package com.tom.Impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import Utils.Config;
import Utils.DBUtil;
import Utils.ToJSON;

import com.tom.Dao.CircleDao;
import com.tom.Model.Circle;

public class CircleImpl implements CircleDao {

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
    ResultSet rs = null;
	
    
    public int CircleIsExit(String Cname){
    	conn = DBUtil.getConnection();	
    	sql = "select Cname from Circle where Cname ='"+Cname+"'";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()){
				@SuppressWarnings("unused")
				String Cname1 = rs.getString("Cname");	
				result=Config.FAILE;
			}else{
				result=Config.SUCCESS;
			}
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		return result;
    
    }
    
	public int CreateCircle(int Uid,String Cname,String Cdesc){
		conn = DBUtil.getConnection();				
					
		try{ 
			sql = "insert into Circle(Uid,Cname,Cdesc) values("
					+ "?,?,?)" ;	
		    psmt = conn.prepareStatement(sql);
		    psmt.setInt(1, Uid);
			psmt.setString(2,Cname);
			psmt.setString(3,Cdesc);
			result = psmt.executeUpdate();
			//conn.close();
			
			if(result>0)
				result = Config.SUCCESS;
			else 
				result = Config.FAILE;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
												  		
		return result;
	}
	
	public List<Circle> getCidByUid(int Uid){
		List list = new ArrayList();
		
        conn=DBUtil.getConnection();
        
		try {
			sql = "select * FROM circle,focusc where circle.Cid=focusc.Cid and focusc.Uid="+Uid;
			psmt = conn.prepareStatement(sql);			
			
			rs = psmt.executeQuery();
			
			
			if(rs.next()){
				Circle c = new Circle();
				c.setCirclename(rs.getString("Cname"));
				c.setCircledesc(rs.getString("Cdesc"));
				c.setCid(rs.getInt("Cid"));
				c.setUid(Uid);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
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
