package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.tom.Service.CircleService;

public class CreateCircleServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCircleServlet() {
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
	 * 需要参数：[String]Cname,Cdesc   [int]Uid
	 * 返回参数：result String   两种情况：创建成功，创建失败
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String UserId,Cname,Cdesc;
		int Uid;
		JSONArray array;
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		UserId = request.getParameter("");
		Cname = request.getParameter("Cname");
		Cdesc = request.getParameter("Cdesc");
		
		Uid = Integer.parseInt(UserId);
		
		CircleService userservice = new CircleService();
		array = userservice.CreateCircle(Uid,Cname,Cdesc);
		
		response.getWriter().print(array);
	}
}
