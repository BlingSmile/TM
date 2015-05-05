package com.tom.Service;

import java.sql.ResultSet;

import com.tom.Dao.UserDao;
import com.tom.Impl.UserImpl;

public class UserService {
	
	UserDao userdao = null;
	ResultSet rs = null;
	int result = -1;
	
	public UserService() {
		userdao = new UserImpl();
	}
	
	public int GetActivcode(String phone) {
		result = userdao.GetActivecode(phone);
		
		return result;
		
	}
	
	public int Register(String phone, String password, int activecode) {
		result = userdao.Register(phone, password, activecode);
		
		return result;
	}
	
	public int Login(String phone, String password) {
		result = userdao.Login(phone, password);
		return result;
	}
	
	public ResultSet GetFucos(int UserId) {
		
	}

}
