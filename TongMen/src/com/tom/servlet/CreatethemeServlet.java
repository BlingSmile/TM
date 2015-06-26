package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String title,content;
		int Uid = -1,Cid = -1;
		ThemeService themeservice = new ThemeService();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		//Uid = (Integer) session.getAttribute("Uid");
		Uid = 2;
		Cid = (Integer) session.getAttribute("Cid");
		title = request.getParameter("title");
		title = new String(title.getBytes("ISO-8859-1"),"UTF8");
		title=java.net.URLDecoder.decode(title, "UTF-8");
		//title = request.getParameter("title");
		content = request.getParameter("content");
		content = new String(content.getBytes("ISO-8859-1"),"UTF8");
		content=java.net.URLDecoder.decode(content, "UTF-8");
		System.out.println(title+content);
		
		
		JSONArray array = new JSONArray();
		array = themeservice.CreateTheme(Cid, Uid, title, content);
		response.getWriter().print(array);
	}

}
