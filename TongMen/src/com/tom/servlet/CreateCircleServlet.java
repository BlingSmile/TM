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
		String Cname,Cdesc,area,school,college,major,Tarea,Tschool,Tcollege,Tmajor,subject;
		int Uid;
		JSONArray array;
		Labelcircle labcic = new Labelcircle();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Uid = (Integer) session.getAttribute("Uid");
		Cname = request.getParameter("Cname");
		Cname = new String(Cname.getBytes("ISO-8859-1"),"UTF8");
		Cname=java.net.URLDecoder.decode(Cname, "UTF-8");
		
		Cdesc = request.getParameter("Cdesc");
		Cdesc = new String(Cdesc.getBytes("ISO-8859-1"),"UTF8");
		Cdesc=java.net.URLDecoder.decode(Cdesc, "UTF-8");
		
		area = request.getParameter("area");
		area = new String(area.getBytes("ISO-8859-1"),"UTF8");
		area=java.net.URLDecoder.decode(area, "UTF-8");

		school = request.getParameter("school");
		school = new String(school.getBytes("ISO-8859-1"),"UTF8");
		school=java.net.URLDecoder.decode(school, "UTF-8");
		
		college = request.getParameter("college");
		college = new String(college.getBytes("ISO-8859-1"),"UTF8");
		college=java.net.URLDecoder.decode(college, "UTF-8");
		
		major = request.getParameter("major");
		major = new String(major.getBytes("ISO-8859-1"),"UTF8");
		major=java.net.URLDecoder.decode(major, "UTF-8");
		
		Tarea = request.getParameter("Tarea");
		Tarea = new String(Tarea.getBytes("ISO-8859-1"),"UTF8");
		Tarea=java.net.URLDecoder.decode(Tarea, "UTF-8");
		
		Tschool= request.getParameter("Tschool");
		Tschool = new String(Tschool.getBytes("ISO-8859-1"),"UTF8");
		Tschool=java.net.URLDecoder.decode(Tschool, "UTF-8");
		
		Tcollege = request.getParameter("Tcollege");
		Tcollege = new String(Tcollege.getBytes("ISO-8859-1"),"UTF8");
		Tcollege=java.net.URLDecoder.decode(Tcollege, "UTF-8");
		
		Tmajor = request.getParameter("Tmajor");
		Tmajor = new String(Tmajor.getBytes("ISO-8859-1"),"UTF8");
		Tmajor=java.net.URLDecoder.decode(Tmajor, "UTF-8");
		
		subject = request.getParameter("subject");
		subject = new String(subject.getBytes("ISO-8859-1"),"UTF8");
		subject=java.net.URLDecoder.decode(subject, "UTF-8");
		
		labcic.setArea(area);
		labcic.setCollege(college);
		labcic.setMajor(major);
		labcic.setSchool(school);
		labcic.setSubject(subject);
		labcic.setTarea(Tarea);
		labcic.setTcollege(Tcollege);
		labcic.setTmajor(Tmajor);
		labcic.setTschool(Tschool);
		
		CircleService userservice = new CircleService();
		array = userservice.CreateCircle(Uid,Cname,Cdesc,labcic);
		
		response.getWriter().print(array);
	}
}
