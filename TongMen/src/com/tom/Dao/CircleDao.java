package com.tom.Dao;

import java.sql.ResultSet;
import java.util.List;

import com.tom.Model.Circle;

public interface CircleDao {

	public int CreateCircle( int uid, String cname, String cdesc);

	public List<Circle> getCidByUid(int uid);
	
	public int CircleIsExit(String Cname);

}
