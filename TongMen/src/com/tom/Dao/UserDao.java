package com.tom.Dao;

import java.sql.ResultSet;

import com.tom.Model.Labelcolle;
import com.tom.Model.User;

public interface UserDao {
	public int Register(String phone, String password, String activecode, String username);
	
	public int GetActivecode(String phone);
	
	public int Login(String phone, String psw);
	
	public ResultSet GetFocus(int userId);
	
	public ResultSet GetWhofucosMe(int userId);
	
	public User GetUserInfo(int userId);
	
	//被关注数
	public int GetBeFucosNum(int userId);
	
	public int GetPraiNum(int userId);
	
	public int UpdateColleLabel(Labelcolle label);
	
	public ResultSet GetColleLabel(int Uid);
	
	public int GetPubthemeNum(int Uid);
	
	public int GetPubrecNum(int Uid);
	
	//关注其他人的数目
	public int GetFucosNum(int Uid);
	
	public ResultSet GetSavetheme(int Uid);
	
	public ResultSet GetSaveresource(int Uid);
	
	public ResultSet GetFocuscircle(int Uid);
	
	public int UpdateUsername(String username, int Uid);
	
	public String GetUsername(int Uid);
	
	public int AddSave(int Uid, int Sid, int type);
	
	public int GetSaveStatu(int Uid, int Sid, int type);
	
	public int DeleteSave(int Uid, int Sid, int type);
	
	public int SendMessage(int fromId, int toId, String message);
	
	public int ResetMessageStatu(int Mid);
	
	public ResultSet GetAllMessage(int Uid);
	
	public int GetUnreadmessageNum(int Uid);
	
	public ResultSet GetMassegetoOther(int Uid, int ToId);
	
	public int AddFucos(int Uid, int Fid);
	
	public int FucosState(int Uid,int Fid);
	
	public int DeleteFucos(int Uid, int Fid);
}
