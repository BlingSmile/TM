package com.tom.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Utils.Config;

import com.tom.Service.UserService;

@SuppressWarnings("unused")
@WebServlet("/RegisterAction")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	 * 需要参数：[String]手机号，密码，昵称   [int]激活码
	 * 返回参数：result String   两种情况：注册成功，注册失败
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String phone,name, psw, res,activecode;
		JSONArray array;
		
		phone = request.getParameter("");
		name = request.getParameter("name");
		psw = request.getParameter("password");
		activecode = request.getParameter("");
		
		UserService userservice = new UserService();
		array = userservice.Register(phone, psw, activecode, name);
		
		response.getWriter().print(array);
	}
}
