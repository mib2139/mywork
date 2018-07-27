package org.gntp.beans;
import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;
import javax.naming.NamingException;
import org.gntp.db.*;

public class InventoryBean {
	private String  model;
	private String  madeby;	
	private String  sort;
	private String  amount;
	private String	total;

	public InventoryBean() {
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMadeby() {
		return madeby;
	}

	public void setMadeby(String madeby) {
		this.madeby = madeby;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
