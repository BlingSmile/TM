package com.tom.Dao;

import java.sql.ResultSet;
import java.util.List;

import com.tom.Model.Circle;
import com.tom.Model.Labelcircle;

public interface CircleDao {

	public int CreateCircle( int uid, String cname, String cdesc, Labelcircle labcic);

	public List<Circle> getCidByUid(int uid);
	
	public int CircleIsExit(String Cname);

	public ResultSet showCircle(int cid);

}
