package com.tom.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.tom.Service.ResourceService;

@WebServlet("/UploadResourceAction")
public class UploadResourceServlet {
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadResourceServlet() {
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
		String Rtitle,Rcontent,Rlink; 
		int Cid,Uid;
		JSONArray array;
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Date d = new Date(System.currentTimeMillis());
		
		Rtitle = request.getParameter("Rtitle");
		Rcontent = request.getParameter("Rcontent");
		Rlink = request.getParameter("Rlink");
		
		
		HttpSession session = request.getSession();
		Uid = (Integer) session.getAttribute("Uid");
		Cid = (Integer) session.getAttribute("Cid");
		
		ResourceService resourceservice = new ResourceService();
		array = resourceservice.UploadResource(Cid,Uid,Rtitle,Rcontent,d,Rlink);
		
		response.getWriter().print(array);
	}
}
