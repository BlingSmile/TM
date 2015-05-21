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
	
	public int GetFucosNum(int userId);
	
	public int GetPraiNum(int userId);
	
	public void UpdateColleLabel(Labelcolle label);
	
	public ResultSet GetColleLabel(int Uid);
}
