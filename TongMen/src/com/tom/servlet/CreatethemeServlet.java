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
 * Servlet implementation class CreatethemeServlet
 */
@WebServlet("/CreatethemeAction")
public class CreatethemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatethemeServlet() {
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
		String CircleId,UserId,title,content;
		int Cid,Uid;
		ThemeService themeservice = new ThemeService();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		CircleId = request.getParameter("");
		UserId = request.getParameter("");
		title = request.getParameter("");
		content = request.getParameter("");
		
		Cid = Integer.parseInt(CircleId);
		Uid = Integer.parseInt(UserId);
		
		JSONArray array = new JSONArray();
		array = themeservice.CreateTheme(Cid, Uid, title, content);
		response.getWriter().print(array);
	}

}
