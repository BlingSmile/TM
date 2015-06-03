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
	
	public int Register(String phone, String password, String activecode, String username) {
		result = userdao.Register(phone, password, activecode, username);
		
		return result;
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
	
	public int UpdateColleLabel(Labelcolle labelcolle) {
		result = userdao.UpdateColleLabel(labelcolle);
		return result;
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
	
	public JSONArray GetSavetheme(int Uid) {
		rs = userdao.GetSavetheme(Uid);
		JSONArray array = new JSONArray(); 
	    array = ToJSON.RsToJson(rs);
	    return array;
	}
	
	public JSONArray GetSaveresource(int Uid) {
		rs = userdao.GetSaveresource(Uid);
		JSONArray array = new JSONArray(); 
	    array = ToJSON.RsToJson(rs);
	    return array;
	}
	
	public JSONArray GetFocuscircle(int Uid) {
		rs = userdao.GetFocuscircle(Uid);
		JSONArray array = new JSONArray(); 
	    array = ToJSON.RsToJson(rs);
	    return array;
	}
	
	public int UpdateUsername(String username, int Uid) {
		result = userdao.UpdateUsername(username,Uid);
		return result;
	}
	
	public String GetUsername(int Uid) {
		return userdao.GetUsername(Uid);
	}
	
	public int AddSave(int Uid, int Sid, int type) {
		return userdao.AddSave(Uid, Sid, type);
	}
	
	public int GetSaveStatu(int Uid, int Sid, int type){
		return userdao.GetSaveStatu(Uid, Sid, type);
	}
	
	public int DeleteSave(int Uid, int Sid, int type){
		return userdao.DeleteSave(Uid, Sid, type);
	}
	
	public int SendMessage(int fromId, int toId, String message) {
		return userdao.SendMessage(fromId, toId, message);
	}
	
	public JSONArray GetAllMessage(int Uid) {
		return ToJSON.RsToJson(userdao.GetAllMessage(Uid));
	}
	
	public int GetUnreadmessageNum(int Uid) {
		return userdao.GetUnreadmessageNum(Uid);
	}
	
	public int ResetMessageStatu(int Uid) {
		return userdao.ResetMessageStatu(Uid);
	}
	
	public JSONArray GetMassegetoOther(int Uid, int ToId) {
		return ToJSON.RsToJson(userdao.GetMassegetoOther(Uid, ToId));
	}
	
	public int AddFucos(int Uid, int Fid) {
		return userdao.AddFucos(Uid, Fid);
	}
	
	public int FucosState(int Uid,int Fid) {
		return userdao.FucosState(Uid,Fid);
	}
	
	public int DeleteFucos(int Uid, int Fid) {
		return userdao.DeleteFucos(Uid,Fid);
	}
}
