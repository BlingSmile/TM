package com.tom.Dao;

import java.sql.Date;
import java.sql.ResultSet;

public interface ResourceDao {
	public ResultSet GetPubRec(int userId);

	public int UploadResource(int cid, int uid, String rtitle, String rcontent,
			Date rdata, String rlink);

	public ResultSet GetResourcelist(int cid);

	public int deleteResource(int cid, int uid);

	public ResultSet SerchByCid(int cid);

	public ResultSet SerchByUid(int uid);


}
