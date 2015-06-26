package com.tom.Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tom.Dao.ThemeDao;
import com.tom.Impl.ThemeImpl;

import Utils.Config;
import Utils.ToJSON;

public class ThemeService {
	
	int result = Config.FAILE;
	ThemeDao themedao = null;
	ResultSet rs = null;
	
	public ThemeService() {
		themedao = new ThemeImpl();
	}
	
	//创建新主题
	public JSONArray CreateTheme(int circleId, int Uid, String title, String content) {
		result = themedao.CreateTheme(circleId, Uid, title, content);
		String res = "";
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(result == Config.FAILE)
			res = "发表失败";
		else
			res = "发表成功";
			
		params.put("result", res);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
	}
	
	//获取圈子主题
	public JSONArray GetThemeList(int circleId) {
		rs = themedao.GetTmemeList(circleId);
		JSONArray array = new JSONArray();
		
		array = ToJSON.RsToJson(rs);
		
		return array;
	}
	
	//获取主题具体内容
	public JSONArray GetThemeInfo(int Tid) {
		rs = themedao.GetThemeInfo(Tid);
		JSONArray array = new JSONArray();
		array = ToJSON.RsToJson(rs);
		return array;
	}
	
	//获取主题回复
	public JSONArray GetThemeReply(int ReTid, int ReType) {
		rs = themedao.GetThemeReply(ReTid, ReType);
		JSONArray array = new JSONArray();
		array = ToJSON.RsToJson(rs);
		return array;
	}
	
	//给主题点赞,并且给主题发布者的点赞总数加一，并且加入点赞记录
	public int AddThemePraise(int Tid, int Pid) {
		result = themedao.AddThemePraise(Tid,Pid);
		return result;
	}
	
	public int DeleteThemepraise(int Tid, int Pid) {
		result = themedao.DeleteThemepraise(Tid,Pid);
		return result;
	}

	//给主题下面的回复点赞,不仅回复的点赞加1，回复者的点赞总数也加一
	public int AddThemeReplyPra(int Reid, int Uid) {
		result = themedao.AddThemeReplyPra(Reid, Uid);
		return result;
	}
	
	//获取主题的回复数
	public int GetThemeReplyNum(int ReTid, int Retype) {
		int ReplyNum = themedao.GetThemeReplyNum(ReTid,Retype);
		
		return ReplyNum;
	}
	
	//删除发布的主题
	public JSONObject DelectTheme(int Uid, int Tid) {
		result = themedao.DelectTheme(Uid, Tid);
		JSONObject object = new JSONObject();
		
		object.put("result", result);
		return object;
	}
	
	public int GetPraisestatu(int Uid,int Tid) {
		result = themedao.GetPraisestatu(Uid,Tid);
		return result;
	}
	
	public int AddReply(int Tid, int Uid, String content) {
		return themedao.AddReply(Tid, Uid, content);
	}
	
}
