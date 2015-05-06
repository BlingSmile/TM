package com.tom.Service;

import com.tom.Dao.UserDao;
import com.tom.Impl.UserImpl;

public class UserService {
	
	UserDao userdao = null;
	
	public UserService() {
		userdao = new UserImpl();
	}
	
	public void GetActivcode(int phone) {
		
	}
	
	public boolean Register(int phone, String password, int activecode) {
		 
		boolean result;
		result = userdao.Register(phone, password, activecode);
		
		return result;
	}

}
