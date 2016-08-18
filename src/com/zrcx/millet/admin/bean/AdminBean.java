package com.zrcx.millet.admin.bean;

public class AdminBean {
	/** id || 后台管理员主键  **/
	private int id;
	/** email || 后台管理员登录的邮箱 **/
	private String email;
	/** pwd || 后台管理员登录密码  **/
	private String pwd;
	/** image || 后台管理员一寸照片  **/
	private String image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "AdminBean [id=" + id + ", email=" + email + ", pwd=" + pwd
				+ ", image=" + image + "]";
	}
	
	
}
