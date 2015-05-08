package Utils;

import java.sql.ResultSet;

import com.tom.Service.CircleService;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*CircleService ci=new CircleService();
		int r= ci.CreateCircle(1520136120,"aihuahua","xuexi");
	
		if(r>0){
			System.out.println("ceshishigong");
		}
		*/
		
		/* ResourceService re=new ResourceService();
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 	Date d = new Date(System.currentTimeMillis());
			//System.out.println(d);
		    int r=re.ResourceService(1,2,"aihuhua","1314",d, "suxiaomo");
		    if(r>0){
		    	System.out.println("ceshishigong");
		    }
		    */
		    CircleService ci=new CircleService();
			ResultSet result= ci.getCidByUid(12301160);
		
			
				System.out.println(result);
			
	}
   
}
