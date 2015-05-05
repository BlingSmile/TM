package Utils;

import com.tom.Service.UserService;

public class test {
	
	public static void main(String arg[]) {
		UserService us = new UserService();
		
		int r = us.Login("18811442530", "123456");
		
		System.out.println(r);
	}

}
