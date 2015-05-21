package com.tom.Service;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import Utils.Config;
import Utils.ToJSON;

import com.tom.Dao.ResourceDao;
import com.tom.Impl.ResourceImpl;

public class ResourceService {
	ResourceDao resourcedao=null;
	ResultSet rs = null;
	int result = Config.FAILE;
	
	public ResourceService() {
		resourcedao = new ResourceImpl();
	}

	public JSONArray ResourceService(int Cid, int Uid, String Rtitle, String Rcontent,Date Rdata,String Rlink)  {
		result = resourcedao.UploadResource(Cid, Uid, Rtitle, Rcontent,Rdata,Rlink);
		String res = "";
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(result == Config.FAILE)
			res = "上传失败";
		else
			res = "上传成功";
			
		params.put("result", res);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
	}
	
	public JSONArray showCircleResource(int Cid,int Uid) {
		rs = resourcedao.showCircleResource(Cid,Uid);
		JSONArray array = new JSONArray();
		
		array = ToJSON.RsToJson(rs);
		
		return array;
	}
	
	public JSONArray deleteResource(int Uid,int Cid)  {
		result = resourcedao.deleteResource(Cid, Uid);
		String res = "";
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(result == Config.FAILE)
			res = "删除失败";
		else
			res = "删除成功";
			
		params.put("result", res);
		JSONArray array = JSONArray.fromObject(params);
		
		return array;
	}
	
	public JSONArray SerchByCid(int Cid) {
		rs = resourcedao.SerchByCid(Cid);
		JSONArray array = new JSONArray();
		
		array = ToJSON.RsToJson(rs);
		
		return array;
	}
	
	public JSONArray SerchByUid(int Uid) {
		rs = resourcedao.SerchByUid(Uid);
		JSONArray array = new JSONArray();
		
		array = ToJSON.RsToJson(rs);
		
		return array;
	}
}
