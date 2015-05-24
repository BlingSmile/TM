package com.tom.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tom.Service.UserService;

@SuppressWarnings("unused")
@WebServlet("/UserFocusAction")
public class UserFocusServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFocusServlet() {
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
	 * 进行两种处理：GetFucosList获得关注的用户列表  GetFucosNum获得当前用户的被关注数目
	 * 需要参数：[int]用户id
	 * 返回参数：[GetFucosList]  通过传回来的jsonarray  获得关注本用户的其他用户信息，包括：用户id，用户名
	 *        [GetFucosNum]  通过focusNum 获得用户的被关注数目
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int Uid;
		int result;
		JSONArray array = new JSONArray();
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession httpsession = request.getSession();
		//Uid = (Integer) httpsession.getAttribute("Uid");
		Uid = 2;
		UserService userservice = new UserService();
		
		String form = request.getParameter("form");
		
		if(form.equals("GetFucosList")){
			array = userservice.GetFucosList(Uid);
			
			response.getWriter().print(array);
			
		} else if(form.equals("GetFucosNum")) {
			int FNum = userservice.GetFucosNum(Uid);
			
			JSONObject JObject = new JSONObject();
			JObject.put("focusNum", FNum);
			
			response.getWriter().print(JObject);
		} else if(form.equals("GetWhofucos")) {
			array = userservice.GetWhofucosMe(Uid);
			response.getWriter().print(array.toString());
		} else if(form.equals("GetFocusciecle")) {
			array = userservice.GetFocuscircle(Uid);
			response.getWriter().print(array.toString());
		}
	}
}
