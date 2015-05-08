package com.tom.Service;

import java.sql.ResultSet;

import com.tom.Dao.CircleDao;
import com.tom.Impl.CircleImpl;

public class CircleService {

CircleDao circledao=null;
	
	public CircleService() {
		circledao = new CircleImpl();
	}
	
	public int CreateCircle(int Uid,String Cname,String Cdesc) {
		int result;
		result = circledao.CreateCircle(Uid,Cname,Cdesc); 
		return result;
		
		
	}

	public ResultSet getCidByUid(int Uid) {
		// TODO Auto-generated method stub
		ResultSet result;
		result=circledao.getCidByUid(Uid);
		return result;
	}

}
