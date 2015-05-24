package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import Utils.Config;

import com.tom.Model.Labelcolle;
import com.tom.Service.UserService;

/**
 * Servlet implementation class GetSavelist
 */
@WebServlet("/GetSavelistAction")
public class GetSavelist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSavelist() {
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
		int Uid = -1;
		String form = "";
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		UserService userservice = new UserService();
		HttpSession session = request.getSession();
		JSONArray array = new JSONArray();
		Uid = (Integer) session.getAttribute("Uid");
		//Uid = 2;
		
		form = request.getParameter("form");
		if(form.equals("ThemeList")) {
			array = userservice.GetSavetheme(Uid);
		} else if(form.equals("RescList")) {
			array = userservice.GetSaveresource(Uid);
		}
		response.getWriter().print(array);
	}

}
