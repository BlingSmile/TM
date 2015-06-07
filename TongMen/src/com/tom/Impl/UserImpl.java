package com.tom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import Utils.Config;
import Utils.DBUtil;

import com.tom.Dao.UserDao;
import com.tom.Model.Labelcolle;
import com.tom.Model.User;

public class UserImpl implements UserDao{

	Connection conn=null;
	PreparedStatement psmt=null;
	String sql = "";
	int result = -1;
	ResultSet rs = null;
	
	@Override
	public int Register(String phone, String password, String activecode, String username) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		try {
			sql = "insert into User(phone,password,username) values("
					+ "?,?,?)" ;
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2,password);
			psmt.setString(3,username);
			result = psmt.executeUpdate();
			
			if(result>0) {
				int Uid;
				sql = "select Uid from User where phone = '"+phone+"'";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				rs.next();
				Uid = rs.getInt("Uid");
				
				sql = "insert into Setting(Uid) values ("+Uid+")";
				psmt = conn.prepareStatement(sql);
				result = psmt.executeUpdate();
				
				sql = "insert into labelcolle(Uid) values(?)";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, Uid);
				result = psmt.executeUpdate();
				
				if(result > 0)
					result = Uid;
				else 
					result = Config.FAILE;
			}
			else
				result = Config.FAILE;
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int GetActivecode(String phone) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		
		sql = "select Uid from User where phone  = '"+ phone +"'";
		
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next())
				result = Config.USER_EXIST;
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	
	@Override
	public int Login(String phone, String psw) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		String password;
		sql = "select Uid,password from User where phone = '" + phone + "'";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(!rs.next())
				result = Config.PHONE_NOT_EXIST;
			else 
			{
				password = rs.getString("password");
				if(psw.equals(password)) {
					result = rs.getInt("Uid");
				}
				else
					result = Config.WRONG_PSW;
					
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultSet GetFocus(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select user.Uid,username,'describe' from user,focusu where user.Uid = focusu.Fid and focusu.Uid = "+userId;
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public User GetUserInfo(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select* from user where Uid = "+userId;
		System.out.println(sql);
		
		User user = new User();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			user.setUid(rs.getInt("Uid"));
			user.setPhone(rs.getString("phone"));
			user.setPassword(null);
			user.setUsername(rs.getString("username"));
			user.setLevel(rs.getInt("level"));
			user.setSex(rs.getString("sex"));
			user.setPraise(rs.getInt("praise"));
			user.setFucouse(rs.getInt("fucouse"));
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	//被关注数
	public int GetBeFucosNum(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select count(Fid) as focusNum from focusu where Fid = "+userId;
		System.out.println(sql);
		int FoNum = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next())
				FoNum = rs.getInt("focusNum");
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(FoNum);
		return FoNum;
	}
	
	//关注数
	public int GetFucosNum(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select count(Uid) as focusNum from focusu where Uid = "+userId;
		System.out.println(sql);
		int FoNum = 0;
			
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next())
				FoNum = rs.getInt("focusNum");
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println(FoNum);
		return FoNum;
	}

	@Override
	public int GetPraiNum(int userId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select praise from user where Uid = "+userId;
		System.out.println(sql);
		int PraNum = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next())
				PraNum = rs.getInt("praise");
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(PraNum);
		return PraNum;
	}

	@Override
	public int UpdateColleLabel(Labelcolle label) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "update labelcolle set age = ?,grade = ?,school = ?, college = ?,"
				+ "major = ?, area = ?,Tschool = ?,Tcollege = ?,Tmajor = ?,Tmaster = ?, Tarea=?"
				+ "where Uid = " + label.getUid();
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, label.getAge());
			psmt.setInt(2, label.getGrade());
			psmt.setString(3, label.getSchool());
			psmt.setString(4, label.getCollege());
			psmt.setString(5, label.getMajor());
			psmt.setString(6, label.getArea());
			psmt.setString(7, label.getTschool());
			psmt.setString(8, label.getTcollege());
			psmt.setString(9, label.getTmajor());
			psmt.setString(10, label.getTmaster());
			psmt.setString(11, label.getTarea());
			
			result = psmt.executeUpdate();
			if(result > 0)
				result = Config.SUCCESS;
			else
				result = Config.FAILE;
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultSet GetWhofucosMe(int userId) {
		conn = DBUtil.getConnection(); 
		sql = "select user.Uid,username,'describe' from user,focusu where user.Uid = focusu.Uid and focusu.Fid = "+userId;
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet GetColleLabel(int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select username,age,grade,school,college,major,area,Tschool,Tcollege,Tmajor,Tmaster,Tarea from labelcolle,user where labelcolle.Uid = user.Uid and user.Uid = "+Uid;
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int GetPubthemeNum(int Uid) {
		conn = DBUtil.getConnection(); 
		sql = "select count(Uid) as PubthemeNum from theme where Uid = "+Uid;
		System.out.println(sql);
		int PubthemeNum = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next())
				PubthemeNum = rs.getInt("PubthemeNum");
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("发布的主题数目："+PubthemeNum);
		return PubthemeNum;
	}

	@Override
	public int GetPubrecNum(int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select count(Uid) as PubrecNum from resource where Uid = "+Uid;
		System.out.println(sql);
		int PubrecNum = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next())
				PubrecNum = rs.getInt("PubrecNum");
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("发布的资源数目："+PubrecNum);
		return PubrecNum;
	}

	@Override
	public ResultSet GetSavetheme(int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select Tid,Ttitle,Tdate,username,Tcontent from theme,user,save where theme.Uid=user.Uid and theme.Tid=save.Sid and save.Stype = 1 and save.Uid = "+Uid;
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public ResultSet GetSaveresource(int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select Rid,Rtitle,Rdate,username,Rcontent,Rlink from resource,user,save where resource.Uid=user.Uid and resource.Rid=save.Sid and save.Stype = 2 and save.Uid = "+Uid;
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public ResultSet GetFocuscircle(int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select circle.Cid,Cname from circle,focusc where circle.Cid=focusc.Cid and focusc.Uid = "+Uid;
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int UpdateUsername(String username, int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "update user set username = ? where Uid = "+Uid;
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, username);
			result = psmt.executeUpdate();
			if(result > 0)
				result = Config.SUCCESS;
			else
				result = Config.FAILE;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String GetUsername(int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection(); 
		sql = "select username from user where Uid = "+Uid;
		String username = "";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next())
				username = rs.getString("username");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return username;
	}

	@Override
	public int AddSave(int Uid, int Sid, int type) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "insert into save(Uid,Stype,Sid) values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Uid);
			psmt.setInt(2, type);
			psmt.setInt(3, Sid);
			result = psmt.executeUpdate();
			
			if(result > 0)
				result = Config.SUCCESS;
			else
				result = Config.FAILE;
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int GetSaveStatu(int Uid, int Sid, int type) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "select * from save where Uid = ? and Stype = ? and Sid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Uid);
			psmt.setInt(2, type);
			psmt.setInt(3, Sid);
			rs = psmt.executeQuery();
			
			if(rs.next())
				result = Config.SUCCESS;
			else
				result = Config.FAILE;
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int DeleteSave(int Uid, int Sid, int type) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "delete from save where Uid = ? and Stype = ? and Sid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Uid);
			psmt.setInt(2, type);
			psmt.setInt(3, Sid);
			result = psmt.executeUpdate();
			
			if(result > 0)
				result = Config.SUCCESS;
			else
				result = Config.FAILE;
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int SendMessage(int fromId, int toId, String message) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "insert into message(FromId,ToId,Message,Time) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, fromId);
			psmt.setInt(2, toId);
			psmt.setString(3, message);
			psmt.setTimestamp(4, new Timestamp(new Date().getTime()));
			result = psmt.executeUpdate();
			
			if(result > 0)
				result = Config.SUCCESS;
			else
				result = Config.FAILE;
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int ResetMessageStatu(int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "update message set State=1 where ToId ="+Uid;
		try {
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
			
			if(result > 0)
				result = Config.SUCCESS;
			else
				result = Config.FAILE;
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	@Override
	public ResultSet GetAllMessage(int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "select Uid,username,Message,time from user,message where `user`.Uid=message.FromId and ToId="+Uid+" ORDER BY time DESC";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;	
	}

	@Override
	public int GetUnreadmessageNum(int Uid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "select count(Mid) as UnreadmessageNum from message where State=0 and ToId="+Uid;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next())
				result = rs.getInt("UnreadmessageNum");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}


	@Override
	public ResultSet GetMassegetoOther(int Uid, int ToId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "select Message,Time FROM message where FromId = ? and ToId = ? ORDER BY Time DESC";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Uid);
			psmt.setInt(2, ToId);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int AddFucos(int Uid, int Fid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "insert into focusu(Uid,Fid) values(?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Uid);
			psmt.setInt(2, Fid);
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int FucosState(int Uid, int Fid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "select* from focusu where Uid = ? and Fid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Uid);
			psmt.setInt(2, Fid);
			rs = psmt.executeQuery();
			
			if(rs.next())
				result = Config.SUCCESS;
			else
				result = Config.FAILE;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int DeleteFucos(int Uid, int Fid) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		
		sql = "delete from focusu where Uid = ? and Fid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Uid);
			psmt.setInt(2, Fid);
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
