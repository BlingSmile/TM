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
		int grade = 0,Uid = -1,result = -1;
		String form = "";
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//response.setHeader("contentType", "text/html; charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserService userservice = new UserService();
		HttpSession session = request.getSession();
		//Uid = (Integer) session.getAttribute("Uid");
		Uid = 2;
		
		form = request.getParameter("form");
		if(form.equals("update")) {
			Labelcolle label = new Labelcolle();
			JSONObject object = new JSONObject();
			label.setAge(Integer.parseInt(request.getParameter("age")));
			label.setUid(Uid);
			/*for(; grade < 7; grade++) {
				if(Config.grade[grade].equals(request.getParameter("")))
					break;
			}*/
			grade = Integer.parseInt(request.getParameter("grade"));
			label.setGrade(grade);
			label.setArea(new String(request.getParameter("area").getBytes("ISO-8859-1"),"UTF8"));
			label.setCollege(new String(request.getParameter("school").getBytes("ISO-8859-1"),"UTF8"));
			label.setMajor(new String(request.getParameter("college").getBytes("ISO-8859-1"),"UTF8"));
			label.setSchool(new String(request.getParameter("major").getBytes("ISO-8859-1"),"UTF8"));
			label.setTarea(new String(request.getParameter("Tarea").getBytes("ISO-8859-1"),"UTF8"));
			label.setTcollege(new String(request.getParameter("Tcollege").getBytes("ISO-8859-1"),"UTF8"));
			label.setTmajor(new String(request.getParameter("Tmajor").getBytes("ISO-8859-1"),"UTF8"));
			//label.setTmaster("");
			label.setTschool(new String(request.getParameter("Tschool").getBytes("ISO-8859-1"),"UTF8"));
			
			result = userservice.UpdateColleLabel(label);
			result = userservice.UpdateUsername(new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF8"), Uid);
			if(result == Config.SUCCESS)
				object.put("result", "修改成功");
			else
				object.put("result", "修改失败");
			response.getWriter().print(object);
		} else if(form.equals("query")) {
			JSONArray array = new JSONArray();
			
			array = userservice.GetColleLabel(Uid);
			response.getWriter().print(array);
		}
		
	}

}
