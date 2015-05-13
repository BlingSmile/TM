package Utils;

import java.sql.ResultSet;
import java.util.List;

import com.tom.Model.Circle;
import com.tom.Service.CircleService;

public class testsxm {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			/*CircleService ci=new CircleService();
			//int r= ci.CreateCircle(152013612,"aihuahua","xuexi");
			int r= ci.CreateCircle(152013612,"suxiaomo","aihuahua");
			//int r= ci.CreateCircle(123456,"331","123");
			if(r== Config.SUCCESS){
				System.out.println("ceshishigong");
			}
			*/
			
			CircleService ci=new CircleService();
			List r=ci.getCidByUid(123456);
			System.out.println(r);
			for(int i=0;i<r.size();i++){
				Circle c = (Circle) r.get(i);
				String Cname = c.getCirclename();
				String Cdesc = c.getCircledesc();
				System.out.println(Cname+"   "+Cdesc);
			}
			
			
			
			/* ResourceService re=new ResourceService();
			// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 	Date d = new Date(System.currentTimeMillis());
				//System.out.println(d);
			    int r=re.ResourceService(1,2,"aihuhua","1314",d, "suxiaomo");
			    if(r>0){
			    	System.out.println("ceshishigong");
			    }
			    */
			   // CircleService ci=new CircleService();
				//ResultSet result= ci.getCidByUid(12301160);
			
				
					//System.out.println(result);
				
		}
	   
	

}
