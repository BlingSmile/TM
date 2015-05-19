package Utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ToJSON {

	public static JSONArray RsToJson(ResultSet rs)
	{
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
		
		return array;
	}
	
}

