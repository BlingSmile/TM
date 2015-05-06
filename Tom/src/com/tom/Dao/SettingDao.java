package com.tom.Dao;

public interface SettingDao {
	
	public int CloseAllowMessage(int userId);
	
	public int OpenAllowMessage(int userId);
	
	public int CloseAllowInvite(int userId);
	
	public int OpenAllowInvite(int userId);
	
	public int GetMessageStatu(int userId);
	
	public int GetInviteStatu(int userId);
}
