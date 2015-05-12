package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Utils.DBUtil;

import com.tom.Dao.PromoteDao;

public class PromoteImpl implements PromoteDao{
	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
	ResultSet rs = null;
	
	public ResultSet PromoteTheme(){
		conn = DBUtil.getConnection();
		sql = "select FROM relpy ORDER BY Repraise desc";
		System.out.println("");
		
		
		return rs;
		
	}
}
