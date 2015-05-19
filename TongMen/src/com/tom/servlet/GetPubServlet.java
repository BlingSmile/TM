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
@WebServlet("/GetpubAction")
public class GetPubServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPubServlet() {
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
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String form = request.getParameter("form");
		String UserId;
		int Uid;
		UserId = request.getParameter("");
		Uid = Integer.parseInt(UserId);
		UserService userservice = new UserService();
		JSONArray array = new JSONArray();
		
		if(form.equals("GetPubTheme"))
			array = userservice.GetPubThem(Uid);
		else if(form.equals("GetPubRec"))
			array = userservice.GetPubRec(Uid);
		
		response.getWriter().print(array);
	}
}
