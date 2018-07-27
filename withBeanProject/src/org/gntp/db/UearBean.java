package org.gntp.db;
import java.sql.*;
import org.gntp.db.DBConnection;
import java.util.*;

import com.sun.webkit.dom.WheelEventImpl;

import javax.naming.*;

public class UearBean {
	private String model;
	private String making;
	private String classfiy;
	private String amount;
	private String price;
	private String id;
	private String pw;
	
	
	public UearBean() {
		
	}

	
	public boolean checkuser() throws SQLException {
		Connection conn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from userlogin where id=? and pw=?";
			
			psm = conn.prepareStatement(sql);
			psm.setString(1, id);
			psm.setString(2, pw);
			
			rs = psm.executeQuery();
			
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			System.out.println("오류");
		}finally {
			rs.close();
			psm.close();
			conn.close();
		}
		return false;
	}
	
	public boolean adduser(){
		Connection conn = null;
		PreparedStatement psm = null;
		
		
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into pm values(?,?,?,?,?)";
			psm = conn.prepareStatement(sql);
			
			psm.setString(1, model);
			psm.setString(2, making);
			psm.setString(3, classfiy);
			psm.setString(4, amount);
			psm.setString(5, price);
			
			int count = psm.executeUpdate();
			
			if(count>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			System.out.println("오류");
		}finally {
			try {
				psm.close();
				conn.close();
			}catch (Exception e) {
				System.out.println("오류");
			}
		
		}
		return false;
	}
	
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getMaking() {
		return making;
	}


	public void setMaking(String making) {
		this.making = making;
	}


	public String getClassfiy() {
		return classfiy;
	}


	public void setClassfiy(String classfiy) {
		this.classfiy = classfiy;
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


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public boolean deluser() {
		Connection conn = null;
		PreparedStatement psm = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from pm where model=?";
			
			psm = conn.prepareStatement(sql);
			psm.setString(1, model);
			
			int count = psm.executeUpdate();
			
			if(count>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			System.out.println("오류");
		}finally {
			try {
				psm.close();
				conn.close();
			}catch (Exception e) {
				System.out.println("오류");
			}
		}
		return false;
	}
	
	public boolean searchuser() {
		Connection conn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from pm where id=?";
			
			psm = conn.prepareStatement(sql);
			psm.setString(1, id);
			
			rs = psm.executeQuery();
			
			if(rs.next()) {
				this.id = rs.getString("id");
				this.pw = rs.getString("pw");
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			System.out.println("오류");
		}finally {
			try {
				psm.close();
				conn.close();
			}catch (Exception e) {
				System.out.println("오류");
			}
		}
		return false;
	}
	
	public boolean updateitem() {
		Connection conn = null;
		PreparedStatement psm = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "update pm set amount=? where model=?";
			
			psm = conn.prepareStatement(sql);
			psm.setString(1, amount);
			psm.setString(2, model);
			
			int count = psm.executeUpdate();
			
			if(count>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			System.out.println("오류");
		}finally {
			try {
				psm.close();
				conn.close();
			}catch (Exception e) {
				System.out.println("오류");
			}
		}
		return false;
	}
	
	public ArrayList<Vector> itemlist() {
		Connection conn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		ArrayList<Vector> list = new ArrayList<Vector>();
		Vector<String> item = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from pm";
			
			psm = conn.prepareStatement(sql);
			
			rs = psm.executeQuery();
			
			while (rs.next()) {
				item = new Vector<String>();
				
				item.add(rs.getString("model"));
				item.add(rs.getString("making"));
				item.add(rs.getString("classfiy"));
				item.add(rs.getString("amount"));
				item.add(rs.getString("price"));
				
				list.add(item);
				
			}
			
			
		}catch (Exception e) {
			System.out.println("오류");
		}finally {
			try {
				rs.close();
				psm.close();
				conn.close();
			}catch (Exception e) {
				System.out.println("오류");
			}
		}
		return list;
	}
}
