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

import com.tom.Service.ThemeService;
import com.tom.Service.UserService;

/**
 * Servlet implementation class PraiseSevlet
 */
@WebServlet("/GetpraiseAction")
public class PraiseSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PraiseSevlet() {
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
		int Uid = 0, PraiNum = 0, Tid = 0,result = -1;
		String form = "";
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Uid = (Integer) session.getAttribute("Uid");
		form = request.getParameter("form");
		
		if(form.equals("PraiseNum")) {
			UserService userservice = new UserService();
			PraiNum = userservice.GetPraiseNum(Uid);
			Map<String, Integer> params = new HashMap<String, Integer>();
			params.put("PraiNum", PraiNum);
			JSONArray array = JSONArray.fromObject(params);
			response.getWriter().print(array);
			
		} else if(form.equals("AddThemepraise")) {
			Tid = Integer.parseInt(request.getParameter("Tid"));
			ThemeService themeserv = new ThemeService();
			result = themeserv.AddThemePraise(Tid, Uid);
			
		} else if(form.equals("GetPraisestatu")) {
			Tid = Integer.parseInt(request.getParameter("Tid"));
			ThemeService themeserv = new ThemeService();
			result = themeserv.GetPraisestatu(Uid,Tid);
			
			JSONObject object = new JSONObject();
			object.put("result", result);
			response.getWriter().print(object);
			
		} else if(form.equals("DeleteThemepraise")) {
			System.out.println("Delete");
			Tid = Integer.parseInt(request.getParameter("Tid"));
			ThemeService themeserv = new ThemeService();
			result = themeserv.DeleteThemepraise(Tid, Uid);
		}
		
	}

}
