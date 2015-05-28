package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.tom.Service.ResourceService;

@WebServlet("/GetResourcelistAction")
public class GetResourcelistServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public GetResourcelistServlet() {
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
			int Cid;
			JSONArray array = new JSONArray();
			
			HttpSession session = request.getSession();
			Cid = (Integer) session.getAttribute("Cid");
			
			ResourceService resourceservice = new ResourceService();
			array = resourceservice.GetResourcelist(Cid);
			response.getWriter().print(array);
				
		}
}
