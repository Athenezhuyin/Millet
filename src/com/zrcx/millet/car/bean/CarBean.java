package com.zrcx.millet.car.bean;

import java.math.BigDecimal;

public class CarBean {
	//购物车字段
	private int id;
	private int user_id;
	private int goods_id;
	private int number;
	//商品表子段
	private String name;
	private String image;
	private BigDecimal price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CarBean [id=" + id + ", user_id=" + user_id + ", goods_id="
				+ goods_id + ", number=" + number + ", name=" + name
				+ ", image=" + image + ", price=" + price + "]";
	}
	
	
}
