package com.zrcx.millet.gorders.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class GordersBean {
	//订单详情表
	private int id;
	private int goods_id;
	private int orders_id;
	private int number;
	private int addr_id;
	//订单表
	private String code;
	private Timestamp time;
	private int state;
	private int user_id;
	//商品表
	private String name;
	private String image;
	private BigDecimal price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public int getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}
	@Override
	public String toString() {
		return "GordersBean [id=" + id + ", goods_id=" + goods_id
				+ ", orders_id=" + orders_id + ", number=" + number + ", code="
				+ code + ", time=" + time + ", state=" + state + ", user_id="
				+ user_id + ", name=" + name + ", image=" + image + ", price="
				+ price + ", addr_id=" + addr_id + "]";
	}
	
	
}
