package com.tom.Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import Utils.Config;
import Utils.ToJSON;

import com.tom.Dao.CircleDao;
import com.tom.Impl.CircleImpl;
import com.tom.Model.Circle;

public class CircleService {

    CircleDao circledao=null;
    ResultSet rs = null;
    int result = Config.FAILE;
    
	public CircleService() {
		circledao = new CircleImpl();
	}
	
	public JSONArray CreateCircle(int Uid,String Cname,String Cdesc) {
		result = circledao.CreateCircle(Uid,Cname,Cdesc);
		String res = "";
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(result == Config.FAILE)
			res = "创建失败";
		else
			res = "创建成功";
			
		params.put("result", res);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
	}

	public List getCidByUid(int Uid) {
		// TODO Auto-generated method stub
		List list=circledao.getCidByUid(Uid);
		return list;
	}
	
	public JSONArray GetThemeList(int Cid) {
		rs = circledao.showCircle(Cid);
		JSONArray array = new JSONArray();
		
		array = ToJSON.RsToJson(rs);
		
		return array;
    }
}
