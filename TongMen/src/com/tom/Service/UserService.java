package com.tom.Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import Utils.Config;
import Utils.ToJSON;

import com.tom.Dao.ResourceDao;
import com.tom.Dao.ThemeDao;
import com.tom.Dao.UserDao;
import com.tom.Impl.ResourceImpl;
import com.tom.Impl.ThemeImpl;
import com.tom.Impl.UserImpl;
import com.tom.Model.Labelcolle;
import com.tom.Model.User;

public class UserService {
	
	UserDao userdao = null;
	ThemeDao themedao = null;
	ResourceDao resourcedao = null;
	ResultSet rs = null;
	int result = Config.FAILE;
	
	public UserService() {
		userdao = new UserImpl();
		themedao = new ThemeImpl();
		resourcedao = new ResourceImpl();
	}
	
	public int GetActivcode(String phone) {
		result = userdao.GetActivecode(phone);
		
		return result;
	}
	
	public JSONArray Register(String phone, String password, String activecode, String username) {
		result = userdao.Register(phone, password, activecode, username);
		String res = "";
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(result == Config.FAILE)
			res = "注册失败";
		else
			res = "注册成功";
			
		params.put("result", res);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
	}
	
	public int Login(String phone, String password) {
		result = userdao.Login(phone, password);
		return result;
	}
	
	public JSONArray GetFucosList(int UserId) {
		rs = userdao.GetFocus(UserId);
		
		// json数组  
	    JSONArray array = new JSONArray();  
	    
	    array = ToJSON.RsToJson(rs);
		
		return array;
	}
	
	public JSONArray GetWhofucosMe(int UserId) {
		rs = userdao.GetWhofucosMe(UserId);
		
		// json数组  
	    JSONArray array = new JSONArray();  
	    
	    array = ToJSON.RsToJson(rs);
		
		return array;
	}
	
	public JSONArray GetUserInfo(int userId) {
		User us = new User();
		us = userdao.GetUserInfo(userId);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("Uid", Integer.toString(us.getUid()));
		params.put("phone", us.getPhone());
		params.put("username", us.getUsername());
		params.put("level", us.getUsername());
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
	}
	
	public JSONArray GetPubThem(int userId) {
		rs = themedao.GetPubTheme(userId);
		// json数组  
	    JSONArray array = new JSONArray();  
	    array = ToJSON.RsToJson(rs);
		
		return array;
	}
	
	public JSONArray GetPubRec(int userId) {
		rs = resourcedao.GetPubRec(userId);
		
		JSONArray array = new JSONArray();  
	    array = ToJSON.RsToJson(rs);
		
		return array;
	}
	
	public int GetFucosNum(int userId) {
		int FNum = 0;
		FNum = userdao.GetFucosNum(userId);
		
		return FNum;
	}
	
	public int GetBefucosNum(int userId) {
		int FNum = 0;
		FNum = userdao.GetBeFucosNum(userId);
		
		return FNum;
	}
	
	public int GetPraiseNum(int userId) {
		int PraiNum = 0;
		PraiNum = userdao.GetPraiNum(userId);

		return PraiNum;
	}
	
	public void UpdateColleLabel(Labelcolle labelcolle) {
		userdao.UpdateColleLabel(labelcolle);
	}
	
	public JSONArray GetColleLabel(int Uid) {
		rs = userdao.GetColleLabel(Uid);
		JSONArray array = new JSONArray(); 
	    array = ToJSON.RsToJson(rs);
	    return array;
	}
	
	public int GetPubthemeNum(int Uid) {
		int PubthemeNum = userdao.GetPubthemeNum(Uid);
		return PubthemeNum;
	}
	
	public int GetPubrecNum(int Uid) {
		int PubrecNum = userdao.GetPubrecNum(Uid);
		return PubrecNum;
	}
	
	
}
