package com.ssi.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
public class Product {
	@Id
	private int pcode;
	private String pname;
	private int price;
	private int discount;
	
	
	public int getPcode() {
		
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Product [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", discount=" + discount + "]";
	}
	

}
