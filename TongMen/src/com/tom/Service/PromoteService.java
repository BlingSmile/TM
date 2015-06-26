package com.tom.Service;

import java.sql.ResultSet;

import com.tom.Dao.PromoteDao;
import com.tom.Impl.PromoteImpl;
import net.sf.json.JSONArray;
import Utils.Config;
import Utils.ToJSON;

public class PromoteService {
	
	int result = Config.FAILE;
	PromoteDao promotedao = null;
	ResultSet rs = null;
	
	public PromoteService() {
		promotedao = new PromoteImpl();
	}
	
	public JSONArray PromoteTheme() {
		rs = promotedao.PromoteTheme();
		JSONArray array = new JSONArray();
		
		array = ToJSON.RsToJson(rs);
		
		return array;
	}
	
	public JSONArray PromoteCircle() {
		rs = promotedao.PromoteCircle();
		JSONArray array = new JSONArray();
		
		array = ToJSON.RsToJson(rs);
		
		return array;
	}
	
	public JSONArray PromoteUser() {
		rs = promotedao.PromoteUser();
		JSONArray array = new JSONArray();
		
		array = ToJSON.RsToJson(rs);
		
		return array;
	}
}
