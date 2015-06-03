package com.tom.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tom.Service.UserService;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageAction")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserService us = new UserService();
		
		int Uid = -1, ToId = -1, result = -1;
		String Message = "", form = "";
		
		form = request.getParameter("form");
		Uid = (Integer) session.getAttribute("Uid");
		
		if(form.equals("GetUnreadmessageNum")) {
			int UnreadMessNum = us.GetUnreadmessageNum(Uid);
			JSONObject object = new JSONObject();
			object.put("UnreadMessNum", UnreadMessNum);
			response.getWriter().print(object);
		} else if (form.equals("SendMessage")) {
			ToId = Integer.parseInt(request.getParameter("ToId"));
			Message = request.getParameter("Message");
			result = us.SendMessage(Uid, ToId, Message);
			
			
			JSONObject object = new JSONObject();
			object.put("result", result);
			response.getWriter().print(object);
		} else if (form.equals("GetMassegetoOther")) {
			ToId = Integer.parseInt(request.getParameter("ToId"));
			
			JSONArray array = new JSONArray();
			array = us.GetMassegetoOther(Uid, ToId);
			response.getWriter().print(array);
		} else if (form.equals("GetAllMessage")) {
			JSONArray array = new JSONArray();
			array = us.GetAllMessage(Uid);
			result = us.ResetMessageStatu(Uid);
			response.getWriter().print(array);
		}
	}

}
