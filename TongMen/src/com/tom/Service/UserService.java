package com.tom.Service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Utils.Config;

import com.tom.Dao.ResourceDao;
import com.tom.Dao.ThemeDao;
import com.tom.Dao.UserDao;
import com.tom.Impl.ResourceImpl;
import com.tom.Impl.ThemeImpl;
import com.tom.Impl.UserImpl;
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
			res = "手机号未注册";
		else if(result == Config.WRONG_PSW)
			res = "密码错误";
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
	    
	    // 获取列数  
	    ResultSetMetaData metaData;
	    
		try {
			metaData = rs.getMetaData();
		  
		    int columnCount = metaData.getColumnCount();  
		    
		    // 遍历ResultSet中的每条数据  
		    while (rs.next()) {  
		        JSONObject jsonObj = new JSONObject();  
		         
		        // 遍历每一列  
		        for (int i = 1; i <= columnCount; i++) {  
		            String columnName =metaData.getColumnLabel(i);  
		            String value = rs.getString(columnName);  
		            jsonObj.put(columnName, value);  
		        }   
		        array.add(jsonObj);   
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}
	
	public User GetUserInfo(int userId) {
		User us = new User();
		us = userdao.GetUserInfo(userId);
		return us;
	}
	
	public ResultSet GetPubThem(int userId) {
		rs = themedao.GetPubTheme(userId);
		return rs;
	}
	
	public ResultSet GetPubRec(int userId) {
		rs = resourcedao.GetPubRec(2);
		return rs;
	}
	
	public JSONArray GetFucosNum(int userId) {
		int FNum = 0;
		FNum = userdao.GetFucosNum(userId);
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("focusNum", FNum);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
	}
	
	public int GetPraiseNum(int userId) {
		int PraiNum = 0;
		PraiNum = userdao.GetPraiNum(userId);
		return PraiNum;
	}

}
