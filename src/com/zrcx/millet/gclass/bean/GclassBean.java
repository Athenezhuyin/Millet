package com.zrcx.millet.gclass.bean;

public class GclassBean {
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GclassBean [id=" + id + ", name=" + name + "]";
	}
	
}
