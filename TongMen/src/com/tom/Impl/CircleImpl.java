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
	
     //����Ȧ��
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
	
	//����û�id��ȡ��ע��Ȧ��
	public ResultSet getCidByUid(int Uid){
        conn=DBUtil.getConnection();
		
		try {
			sql = "select Cname,Cdesc FROM circle,focusc where circle.Cid=focusc.Cid and focusc.Uid="+Uid;
			System.out.println("���Uid���Ȧ��"+Uid);
			psmt = conn.prepareStatement(sql);
			//psmt.setInt(1, Uid);			
			
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
	
	//չʾȦ������
	public ResultSet showCircle(int Cid){
		 conn=DBUtil.getConnection();
		 try{
		 sql = "select Cname��Cdesc FROM Circle Where circle.Cid= "+Cid;
		 System.out.println("���Ȧ��id"+Cid+"��ȡȦ����Ϣ");
			psmt = conn.prepareStatement(sql);						
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
}
