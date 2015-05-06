package com.tom.Model;

public class Circle {
      private int Cid; 
	  private int Uid;
      private String Cname;
      private String Cdesc;

      public int getPhone() {
		return Uid;
	}
	public void setPhone(int phone) {
		this.Uid = phone;
	}
	public String getCirclename() {
		return Cname;
	}
	public void setCirclename(String circlename) {
		Cname = circlename;
	}
	public String getCircledesc() {
		return Cdesc;
	}
	public void setCircledesc(String circledesc) {
		Cdesc = circledesc;
	}
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
      
      
}
