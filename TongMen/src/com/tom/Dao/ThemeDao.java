package com.tom.Dao;

import java.sql.ResultSet;

public interface ThemeDao {
	public ResultSet GetPubTheme(int userId);
	
	public int CreateTheme(int circleId, int Uid, String title, String content);
	
	public ResultSet GetTmemeList(int circleId);
	
	public ResultSet GetThemeInfo(int Tid);
	
	public ResultSet GetThemeReply(int ReTid, int ReType);
	
	public int AddThemePraise(int Tid,int Uid,int Pid);
	
	public int AddThemeReplyPra(int Reid, int Uid);
	
	public int GetThemeReplyNum(int ReTid, int Retype);
	
	public int DelectTheme(int Uid, int Tid);
}
