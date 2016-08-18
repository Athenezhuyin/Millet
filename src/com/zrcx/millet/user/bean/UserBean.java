package com.zrcx.millet.user.bean;

public class UserBean {
	private int id;
	private String pwd;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", pwd=" + pwd + ", phone=" + phone + "]";
	}
	
}
