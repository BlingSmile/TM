package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.tom.Service.UserService;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveAction")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
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
		int Uid = -1, Sid = -1, type = -1, result = -1;
		String form = "";
		
		HttpSession session = request.getSession();
		Uid = (Integer) session.getAttribute("Uid");
		Sid = Integer.parseInt(request.getParameter("Tid"));
		type = Integer.parseInt(request.getParameter("type"));
		form = request.getParameter("form");
		
		UserService us = new UserService();

		if (form.equals("GetSaveStatu")) {
			result = us.GetSaveStatu(Uid, Sid, type);
		} else if (form.equals("AddSave")) {
			result = us.AddSave(Uid, Sid, type);
		} else if (form.equals("DeleteSave")) {
			result = us.DeleteSave(Uid, Sid, type);
		}
		
		JSONObject object = new JSONObject();
		object.put("result", result);
		response.getWriter().print(object);
		
	}

}
