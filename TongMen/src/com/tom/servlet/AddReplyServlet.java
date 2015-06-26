package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import Utils.Config;

import com.tom.Service.ThemeService;
import com.tom.Service.UserService;

/**
 * Servlet implementation class AddReplyServlet
 */
@WebServlet("/AddReplyAction")
public class AddReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReplyServlet() {
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
		
		int Uid = -1, Tid = -1,result = -1;
		String content = "";
		
		HttpSession session = request.getSession();
		Uid = (Integer) session.getAttribute("Uid");
		content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF8");
		Tid = Integer.parseInt(request.getParameter("Tid"));
		
		ThemeService theme = new ThemeService();
		UserService user = new UserService();
		result = theme.AddReply(Tid, Uid, content);
		JSONObject object = new JSONObject();
		System.out.println("shuchu");
		if(result == Config.SUCCESS) {
			object.put("result", "回复成功");
			String username = user.GetUsername(Uid);
			object.put("username", username);
			response.getWriter().print(object);
		} else {
			object.put("result", "回复失败");
			response.getWriter().print(object);
		}
	}

}
