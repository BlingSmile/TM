package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tom.Service.ThemeService;

/**
 * Servlet implementation class ThemeinfoServlet
 */
@WebServlet("/ThemeinfoAction")
public class ThemeinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemeinfoServlet() {
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
		String ThemeId;
		int Tid = -1,ReplyNum = -1;
		ThemeService themeservice = new ThemeService();
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//CircleId = request.getParameter("CircleId");
		ThemeId = request.getParameter("Tid");
		
		//Cid = Integer.parseInt(CircleId);
		Tid = Integer.parseInt(ThemeId);
		
		array = themeservice.GetThemeInfo(Tid);
		ReplyNum = themeservice.GetThemeReplyNum(Tid, 1);
		object.put("ReplyNum", ReplyNum);
		array.add(object);
		response.getWriter().print(array);
	}

}
