package com.tom.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.tom.Service.ResourceService;

public class UploadResourceServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadResourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 需要参数：[String]Rtitle,Rcontent,Rlink   [int]Cid,Uid
	 * 返回参数：result String   两种情况：上传成功 上传失败
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String UserId,CircleId,Rtitle,Rcontent,Rlink; 
		int Cid,Uid;
		JSONArray array;
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Date d = new Date(System.currentTimeMillis());
		
		UserId = request.getParameter("");
		CircleId = request.getParameter("");
		Rtitle = request.getParameter("Rtitle");
		Rcontent = request.getParameter("Rcontent");
		Rlink = request.getParameter("Rlink");
		
		Uid = Integer.parseInt(UserId);
		Cid = Integer.parseInt(CircleId);
		
		ResourceService resourceservice = new ResourceService();
		array = resourceservice.UploadResource(Cid,Uid,Rtitle,Rcontent,d,Rlink);
		
		response.getWriter().print(array);
	}
}
