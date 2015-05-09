package com.tom.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tom.Service.UserService;

@SuppressWarnings("unused")
@WebServlet("/RegisterAction")
public class UserFocusServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFocusServlet() {
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
	 * 进行两种处理：GetFucosList获得关注的用户列表  GetFucosNum获得当前用户的被关注数目
	 * 需要参数：[int]用户id
	 * 返回参数：[GetFucosList]  通过传回来的jsonarray  获得关注本用户的其他用户信息，包括：用户id，用户名
	 *        [GetFucosNum]  通过focusNum 获得用户的被关注数目
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String Uid;
		int userId;
		int result;
	
		Uid = request.getParameter("");
		userId = Integer.parseInt(Uid);
		
		UserService userservice = new UserService();
		
		String form = request.getParameter("form");
		if(form.equals("GetFucosList")){
			ResultSet rs = userservice.GetFucosList(userId);
			
			// json数组  
		    JSONArray array = new JSONArray();  
		    
		    // 获取列数  
		    ResultSetMetaData metaData;
			try {
				metaData = rs.getMetaData();
			  
			    int columnCount = metaData.getColumnCount();  
			    
			    // 遍历ResultSet中的每条数据  
			    while (rs.next()) {  
			        JSONObject jsonObj = new JSONObject();  
			         
			        // 遍历每一列  
			        for (int i = 1; i <= columnCount; i++) {  
			            String columnName =metaData.getColumnLabel(i);  
			            String value = rs.getString(columnName);  
			            jsonObj.put(columnName, value);  
			        }   
			        array.add(jsonObj);   
			    }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(array);
		} else if(form.equals("GetFucosNum")) {
			int FocNum = userservice.GetFucosNum(userId);
			Map<String, Integer> params = new HashMap<String, Integer>();
			params.put("focusNum", FocNum);
			
			JSONArray array = JSONArray.fromObject(params);
			response.getWriter().print(array.toString());
		}
	}
}
