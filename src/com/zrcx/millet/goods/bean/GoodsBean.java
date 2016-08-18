package com.zrcx.millet.goods.bean;

import java.math.BigDecimal;

public class GoodsBean {
	private int id;
	private String name;
	private String image;
	private BigDecimal price;
	private String description;
	private int gclass_id;
	private String gname;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGclass_id() {
		return gclass_id;
	}
	public void setGclass_id(int gclass_id) {
		this.gclass_id = gclass_id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	@Override
	public String toString() {
		return "GoodsBean [id=" + id + ", name=" + name + ", image=" + image
				+ ", price=" + price + ", description=" + description
				+ ", gclass_id=" + gclass_id + ", gname=" + gname + "]";
	}
	
}
