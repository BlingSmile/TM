package com.tom.Service;

import java.sql.ResultSet;
import java.util.List;

import Utils.Config;

import com.tom.Dao.CircleDao;
import com.tom.Impl.CircleImpl;

public class CircleService {

CircleDao circledao=null;
	
	public CircleService() {
		circledao = new CircleImpl();
	}
	
	public int CreateCircle(int Uid,String Cname,String Cdesc) {
		int result;
		result = circledao.CircleIsExit(Cname);
		if(result == Config.SUCCESS)
			result = circledao.CreateCircle(Uid,Cname,Cdesc); 
		
		return result;
	
	}

	public List getCidByUid(int Uid) {
		// TODO Auto-generated method stub
		List list=circledao.getCidByUid(Uid);
		return list;
	}

}
