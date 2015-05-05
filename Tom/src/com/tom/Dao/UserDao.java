package com.tom.Dao;

import java.sql.ResultSet;

public interface UserDao {
	public int Register(String phone, String password, int activecode);
	
	public int GetActivecode(String phone);
	
	public int Login(String phone, String psw);
	
	public ResultSet GetFocus(int userId);
}
