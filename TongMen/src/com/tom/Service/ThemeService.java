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
	
	//创建新主题
	public int CreateTheme(int circleId, int Uid, String title, String content) {
		result = themedao.CreateTheme(circleId, Uid, title, content);
		return result;
	}
	
	//获取圈子主题
	public ResultSet GetThemeList(int circleId) {
		rs = themedao.GetTmemeList(circleId);
		return rs;
	}
	
	//获取主题具体内容
	public ResultSet GetThemeInfo(int circleId, int Tid) {
		rs = themedao.GetThemeInfo(circleId, Tid);
		return rs;
	}
	
	//获取主题回复
	public ResultSet GetThemeReply(int ReTid, int ReType) {
		rs = themedao.GetThemeReply(ReTid, ReType);
		return rs;
	}
	
	//给主题点赞,并且给主题发布者的点赞总数加一，并且加入点赞记录
	public int AddThemePraise(int Tid, int Uid, int Pid) {
		result = themedao.AddThemePraise(Tid,Uid,Pid);
		return result;
	}

	//给主题下面的回复点赞,不仅回复的点赞加1，回复者的点赞总数也加一
	public int AddThemeReplyPra(int Reid, int Uid) {
		result = themedao.AddThemeReplyPra(Reid, Uid);
		return result;
	}
}
