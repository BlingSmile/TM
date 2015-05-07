package com.tom.Dao;

import java.sql.ResultSet;

public interface CircleDao {

	public int CreateCircle( int uid, String cname, String cdesc);

	public ResultSet getCidByUid(int uid);

}
