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
	
	public int CloseAllowMessage(int userId) {
		result = settingdao.CloseAllowMessage(userId);
		return result;
	}
	
	public int OpenAllowMessage(int userId) {
		result = settingdao.OpenAllowMessage(userId);
		return result;
	}

	public int CloseAllowInvite(int userId) {
		result = settingdao.CloseAllowInvite(userId);
		return result;
	}
	
	public int OpenAllowInvite(int userId) {
		result = settingdao.OpenAllowInvite(userId);
		return result;
	}
	
	public int GetMessageStatu(int userId) {
		result = settingdao.GetMessageStatu(userId);
		return result;
	}
	
	public int GetInviteStatu(int userId) {
		result = settingdao.GetInviteStatu(userId);
		return result;
	}
}
