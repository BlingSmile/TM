package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBUtil;

import com.tom.Dao.ResourceDao;

public class ResourceImpl implements ResourceDao{

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
	ResultSet rs = null;
	
	@Override
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

}
