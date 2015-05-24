package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.tom.Model.Labelcircle;
import com.tom.Service.CircleService;

@WebServlet("/CreateCircleAction")
public class CreateCircleServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCircleServlet() {
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
		String Cname,Cdesc;
		int Uid;
		JSONArray array;
		Labelcircle labcic = new Labelcircle();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Uid = (Integer) session.getAttribute("Uid");
		
		Cname = request.getParameter("Cname");
		Cdesc = request.getParameter("Cdesc");
		labcic.setArea(request.getParameter("area"));
		labcic.setCollege(request.getParameter("college"));
		labcic.setMajor(request.getParameter("major"));
		labcic.setSchool(request.getParameter("school"));
		labcic.setSubject(request.getParameter("subject"));
		labcic.setTarea(request.getParameter("Tarea"));
		labcic.setTcollege(request.getParameter("Tcollege"));
		labcic.setTmajor(request.getParameter("Tschool"));
		labcic.setTschool(request.getParameter("Tmajor"));
		
		CircleService userservice = new CircleService();
		array = userservice.CreateCircle(Uid,Cname,Cdesc,labcic);
		
		response.getWriter().print(array);
	}
}
