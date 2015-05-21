package com.tom.Dao;

import java.sql.ResultSet;

public interface PromoteDao {
	public ResultSet PromoteTheme();//推送主题

	public ResultSet PromoteCircle();

	public ResultSet PromoteUser();
}
