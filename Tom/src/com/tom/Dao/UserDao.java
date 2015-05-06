package com.tom.Dao;

import java.sql.ResultSet;

import com.tom.Model.User;

public interface UserDao {
	public int Register(String phone, String password, int activecode, String username);
	
	public int GetActivecode(String phone);
	
	public int Login(String phone, String psw);
	
	public ResultSet GetFocus(int userId);
	
	public User GetUserInfo(int userId);
	
	public int GetFucosNum(int userId);
	
	public int GetPraiNum(int userId);
}
