package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.tom.Service.ThemeService;

/**
 * Servlet implementation class AddpraiseServlet
 */
@WebServlet("/AddpraiseAction")
public class AddpraiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddpraiseServlet() {
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
		String CircleId,ThemeId,form;
		int Cid,Tid;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ThemeService themeservice = new ThemeService();
		JSONArray array = new JSONArray();
		
		CircleId = request.getParameter("");
		ThemeId = request.getParameter("");
		form = request.getParameter("");
		
		Cid = Integer.parseInt(CircleId);
		Tid = Integer.parseInt(ThemeId);
		
		array = themeservice.GetThemeInfo(Cid, Tid);
		response.getWriter().print(array);
		
	}

}
