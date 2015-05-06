package com.tom.Service;

import Utils.Config;

import com.tom.Dao.SettingDao;
import com.tom.Impl.SettingImpl;

public class SettingService {
	
	int result = Config.FAILE;
	SettingDao settingdao = null;
	
	public SettingService() {
		settingdao = new SettingImpl();
	}
	
	//关闭接受私信设置
	public int CloseAllowMessage(int userId) {
		result = settingdao.CloseAllowMessage(userId);
		return result;
	}
	
	//开启接收私信设置
	public int OpenAllowMessage(int userId) {
		result = settingdao.OpenAllowMessage(userId);
		return result;
	}

	//关闭接受邀请设置
	public int CloseAllowInvite(int userId) {
		result = settingdao.CloseAllowInvite(userId);
		return result;
	}
	
	//开启接受邀请设置
	public int OpenAllowInvite(int userId) {
		result = settingdao.OpenAllowInvite(userId);
		return result;
	}
	
	//获得接受私信设置的状态
	public int GetMessageStatu(int userId) {
		result = settingdao.GetMessageStatu(userId);
		return result;
	}
	
	//获得接受邀请设置的状态
	public int GetInviteStatu(int userId) {
		result = settingdao.GetInviteStatu(userId);
		return result;
	}
}
