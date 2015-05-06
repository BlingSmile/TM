package com.tom.Dao;

import java.sql.ResultSet;

public interface ThemeDao {
	public ResultSet GetPubTheme(int userId);
	
	public int CreateTheme(int circleId, int Uid, String title, String content);
	
	public ResultSet GetTmemeLisi(int circleId);

}
