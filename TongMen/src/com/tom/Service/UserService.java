package com.tom.Service;

import java.sql.ResultSet;

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
	
	public int Register(String phone, String password, int activecode, String username) {
		result = userdao.Register(phone, password, activecode, username);
		
		return result;
	}
	
	public int Login(String phone, String password) {
		result = userdao.Login(phone, password);
		return result;
	}
	
	//����û���ע�����û����б�
	public ResultSet GetFucosList(int UserId) {
		rs = userdao.GetFocus(UserId);
		return rs;
	}
	
	//����û���Ϣ
	public User GetUserInfo(int userId) {
		User us = new User();
		us = userdao.GetUserInfo(userId);
		return us;
	}
	
	//����û�����������
	public ResultSet GetPubThem(int userId) {
		rs = themedao.GetPubTheme(userId);
		return rs;
	}
	
	//��ȡ�û���������Դ�б�
	public ResultSet GetPubRec(int userId) {
		rs = resourcedao.GetPubRec(2);
		return rs;
	}
	
	//��ñ���ע��Ŀ
	public int GetFucosNum(int userId) {
		int FNum = 0;
		FNum = userdao.GetFucosNum(userId);
		return FNum;
	}
	
	//��ñ���������
	public int GetPraiseNum(int userId) {
		int PraiNum = 0;
		PraiNum = userdao.GetPraiNum(userId);
		return PraiNum;
	}

}
