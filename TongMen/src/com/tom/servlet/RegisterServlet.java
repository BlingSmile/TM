package com.tom.servlet;

import java.io.IOException;
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
		int Uid = -1;
		JSONObject object = new JSONObject();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		phone = request.getParameter("phone");
		name = request.getParameter("name");
		psw = request.getParameter("password");
		//activecode = request.getParameter("");
		
		UserService userservice = new UserService();
		Uid = userservice.Register(phone, psw, "111", name);
		
		if(Uid != Config.FAILE) {
			HttpSession session = request.getSession();
			session.setAttribute("Uid", Uid);
			object.put("result", "注册成功");
		} else {
			object.put("result", "注册失败");
		}
		
		response.getWriter().print(object);
	}
}
