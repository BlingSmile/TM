package com.tom.Service;

import java.sql.Date;

import com.tom.Dao.ResourceDao;
import com.tom.Impl.ResourceImpl;

public class ResourceService {
	ResourceDao Resourcedao=null;
	int result;
	
	public ResourceService() {
		Resourcedao = new ResourceImpl();
	}

	public int ResourceService(int Cid, int Uid, String Rtitle, String Rcontent,Date Rdata,
			String Rlink) {
		result = Resourcedao.UploadResource(Cid,Uid,Rtitle,Rcontent,Rdata,Rlink); 
		return result;
	}
}
