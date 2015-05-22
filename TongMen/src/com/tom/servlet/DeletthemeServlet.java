package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tom.Service.ThemeService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DeletthemeServlet
 */
@WebServlet("/DeletthemeAction")
public class DeletthemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletthemeServlet() {
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
		int Uid = -1, Tid = -1;
		JSONObject object = new JSONObject();
		ThemeService theserv = new ThemeService();
		HttpSession session = request.getSession();
		
		Tid = Integer.parseInt(request.getParameter(""));
		Uid = (Integer) session.getAttribute("Uid");
		
		object = theserv.DelectTheme(Uid, Tid);
		response.getWriter().print(object);
	}

}
