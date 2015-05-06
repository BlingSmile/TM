package com.tom.Model;

public class User {
	private int Uid;
	private String phone;
	private String password;
	private int level;
	private String username;
	private String sex;
	private int praise;
	private int fucouse;
	
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public int getFucouse() {
		return fucouse;
	}
	public void setFucouse(int fucouse) {
		this.fucouse = fucouse;
	}
	
}
