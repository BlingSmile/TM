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
 * Servlet implementation class UpdateUserinfoServlet
 */
@WebServlet("/CollelabelAction")
public class CollelabelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollelabelServlet() {
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
		int grade = 0,Uid = -1;
		String form = "";
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		UserService userservice = new UserService();
		HttpSession session = request.getSession();
		//Uid = session.getAttribute("Uid");
		Uid = 2;
		
		form = request.getParameter("form");
		if(form.equals("update")) {
			Labelcolle label = new Labelcolle();
			label.setAge(Integer.parseInt(request.getParameter("")));
			label.setUid(Uid);
			for(; grade < 7; grade++) {
				if(Config.grade[grade].equals(request.getParameter("")))
					break;
			}
			label.setGrade(grade+1);
			label.setArea(request.getParameter(""));
			label.setCollege(request.getParameter(""));
			label.setMajor(request.getParameter(""));
			label.setSchool(request.getParameter(""));
			label.setTarea(request.getParameter(""));
			label.setTcollege(request.getParameter(""));
			label.setTmajor(request.getParameter(""));
			label.setTmaster(request.getParameter(""));
			label.setTschool(request.getParameter(""));
			
			userservice.UpdateColleLabel(label);
		} else if(form.equals("query")) {
			JSONArray array = new JSONArray();
			
			array = userservice.GetColleLabel(Uid);
			response.getWriter().print(array);
		}
		
	}

}
