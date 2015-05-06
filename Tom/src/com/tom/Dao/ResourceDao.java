package com.tom.Dao;

import java.sql.Date;


public interface ResourceDao {

	int UploadResource(int cid, int uid, String rtitle, String rcontent,Date rdata,
			String rlink);

}
