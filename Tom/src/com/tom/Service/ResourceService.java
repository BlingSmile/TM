package com.tom.Service;


import java.sql.Date;

import com.tom.Dao.ResourceDao;
import com.tom.Impl.CircleImpl;
import com.tom.Impl.ResourceImpl;

public class ResourceService {
	ResourceDao Resourcedao=null;
	
	public ResourceService() {
		Resourcedao = new ResourceImpl();
	}

	public int ResourceService(int Cid, int Uid, String Rtitle, String Rcontent,Date Rdata,
			String Rlink) {
		// TODO Auto-generated method stub
		int result;
		result = Resourcedao.UploadResource(Cid,Uid,Rtitle,Rcontent,Rdata,Rlink); 
		return result;
	}
}
