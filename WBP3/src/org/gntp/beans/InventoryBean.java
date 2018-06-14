package org.gntp.beans;
import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;
import javax.naming.NamingException;
import org.gntp.db.*;

public class InventoryBean {

	private String bnum;
	private String pname;
	private String model;
	private String company;
	private String cate;
	private String amount;
	private String price;
	private String img;

	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

}
