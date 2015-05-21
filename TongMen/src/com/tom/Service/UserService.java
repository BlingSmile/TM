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
			res = "注册成功";
		else
			res = "注册成功";
			
		params.put("result", res);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
	}
	
	public JSONArray Login(String phone, String password) {
		result = userdao.Login(phone, password);
		String res = "";
		
		Map<String, String> params = new HashMap<String, String>();
		if(result == Config.PHONE_NOT_EXIST)
			res = "用户名或密码错误";
		else if(result == Config.WRONG_PSW)
			res = "用户名或密码错误";
		else
			res = "登陆成功";
			
		params.put("result", res);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
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
	
	public JSONArray GetFucosNum(int userId) {
		int FNum = 0;
		FNum = userdao.GetFucosNum(userId);
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("focusNum", FNum);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
	}
	
	public JSONArray GetPraiseNum(int userId) {
		int PraiNum = 0;
		PraiNum = userdao.GetPraiNum(userId);

		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("focusNum", PraiNum);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
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
}
