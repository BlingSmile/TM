package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.tom.Service.CircleService;
import com.tom.Service.ResourceService;

public class ShowCircleReServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ShowCircleReServlet() {
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
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String Cid,Uid;
			int circleId,userId;
			int result;
			JSONArray array = new JSONArray();
		
			Cid = request.getParameter("");
			Uid = request.getParameter("");
			circleId = Integer.parseInt(Cid);
			userId = Integer.parseInt(Uid);
			
			ResourceService resourceservice = new ResourceService();
			
			array = resourceservice.showCircleResource(circleId,userId);
			response.getWriter().print(array);
				
		}
}
