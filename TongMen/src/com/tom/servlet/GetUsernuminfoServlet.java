package com.tom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tom.Service.UserService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetUsernuminfoServlet
 */
@WebServlet("/GetUsernuminfoAction")
public class GetUsernuminfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUsernuminfoServlet() {
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
		int focusNum = 0, pubthemeNum = 0, pubrecNum = 0, befocusNum = 0, praiNum = 0;
		int Uid = 0;
		String user = "";
		UserService userservice = new UserService();
		
		
		
		user = request.getParameter("user");
		if(user.equals("personal")) {
			HttpSession session = request.getSession();
			Uid = (Integer) session.getAttribute("Uid");
		} else if(user.equals("other")) 
			Uid = Integer.parseInt(request.getParameter("Uid"));
		
		
		
		JSONObject JObject = new JSONObject();
		focusNum = userservice.GetFucosNum(Uid);
		pubthemeNum = userservice.GetPubthemeNum(Uid);
		pubrecNum = userservice.GetPubrecNum(Uid);
		befocusNum = userservice.GetBefucosNum(Uid);
		praiNum = userservice.GetPraiseNum(Uid);
		JObject.put("focusNum", focusNum);
		JObject.put("pubthemeNum", pubthemeNum);
		JObject.put("pubrecNum", pubrecNum);
		JObject.put("befocusNum", befocusNum);
		JObject.put("praiNum", praiNum);
		
		response.getWriter().print(JObject);
		
	}

}
