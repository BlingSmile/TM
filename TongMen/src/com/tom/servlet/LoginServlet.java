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
@WebServlet("/LoginAction")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	 * 需要参数：用户名username即手机号，密码
	 * 返回参数：result String   三种情况：手机号未注册，密码错误，登陆成功
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name, psw;
		name = request.getParameter("name");
		psw = request.getParameter("password");
		UserService userservice = new UserService();
		System.out.println(name+psw);
		int result = userservice.Login(name, psw);
		
		String res = "";
		
		Map<String, String> params = new HashMap<String, String>();
		if(result == Config.PHONE_NOT_EXIST)
			res = "用户名或密码错误";
		else if(result == Config.WRONG_PSW)
			res = "用户名或密码错误";
		else {
			res = "登陆成功";
		}
		params.put("result", res);
		JSONArray array = JSONArray.fromObject(params);
		
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("Uid", result);
		
		response.getWriter().print(array);
	}
}
