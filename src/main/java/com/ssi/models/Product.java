package com.ssi.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


@Entity
public class Product {
	@Id
//	@Min(101)
//	@Max(1000)
	@Range(min=101,max=1000 ,message="Product code must in range of 101  to 1000")
	private int pcode;
	@Pattern(regexp="[a-z A-z]*",message="Only Alphabets are allowed in product name")
	@Size(min=3,max=15,message="Product name must be in 3-15 chars long")
	private String pname;
	@Min(value=100 , message="Minimum price allowed is:100")
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
