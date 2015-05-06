package com.tom.Service;

import java.sql.ResultSet;

import com.tom.Dao.ThemeDao;
import com.tom.Impl.ThemeImpl;

import Utils.Config;

public class ThemeService {
	
	int result = Config.FAILE;
	ThemeDao themedao = null;
	ResultSet rs = null;
	
	public ThemeService() {
		themedao = new ThemeImpl();
	}
	
	public int CreateTheme(int circleId, int Uid, String title, String content) {
		result = themedao.CreateTheme(circleId, Uid, title, content);
		return result;
	}
	
	public ResultSet GetThemeList(int circleId) {
		
		return rs;
	}

}
