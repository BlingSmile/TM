package Utils;

import com.tom.Impl.ThemeImpl;
import com.tom.Model.User;
import com.tom.Service.SettingService;
import com.tom.Service.ThemeService;
import com.tom.Service.UserService;

public class test {
	
	public static void main(String arg[]) {
		//UserService us = new UserService();
		//ThemeImpl tl = new ThemeImpl();
		//us.Login("18811442530", "123456");
		//User user = new User();
		//SettingService ss = new SettingService();
		//System.out.println(ss.OpenAllowInvite(2));
		//System.out.println(ss.GetInviteStatu(2));
		//user =  us.GetUserInfo(2);
		//us.GetPubThem(2);
		//us.GetFucosNum(4);
		//us.GetPraiseNum(2);
		//System.out.println(r);
		
		ThemeService ts = new ThemeService();
		System.out.println(ts.CreateTheme(1, 2, "如何找到合适的导师", "想要报考北大，有没有人知道北大软件工程研究生导师都有谁？以及每个导师的具体情况"));
	}

}
