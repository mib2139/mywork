package org.gntp.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import org.gntp.beans.*;
import org.gntp.db.DBConnection;

public class ManagementBean {

	public InventoryBean getinven(InventoryBean inven) {
		return inven;
	}

	public ArrayList<InventoryBean> listInven(InventoryBean inven) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<InventoryBean> list = new ArrayList<InventoryBean>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from pmm";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				inven = new InventoryBean();

				inven.setBnum(rs.getString("bnum"));
				inven.setPname(rs.getString("pname"));
				inven.setModel(rs.getString("model"));
				inven.setCompany(rs.getString("company"));
				inven.setCate(rs.getString("cate"));
				inven.setAmount(rs.getString("amount"));
				inven.setPrice(rs.getString("price"));

				list.add(inven);
			}

		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("list의 sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}

		return list;
	}

	public boolean deleteinven(InventoryBean inven) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		try {

			conn = DBConnection.getConnection();
			String sql = "delete from pmm where model=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, inven.getModel());

			int count = pstmt.executeUpdate();

			if (count>0) {
				result = true;
			}else {
				result = false;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("delete의 sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}

	public boolean updateInven(InventoryBean inven) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		try{

			conn = DBConnection.getConnection();
			String sql = "UPDATE pmm SET bnum=?, pname=?, company=?, cate=?, amount=?, price=? WHERE model=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, inven.getBnum());
			pstmt.setString(2, inven.getPname());
			pstmt.setString(3, inven.getCompany());
			pstmt.setString(4, inven.getCate());
			pstmt.setString(5, inven.getAmount());
			pstmt.setString(6, inven.getPrice());
			pstmt.setString(7, inven.getModel());

			int count = pstmt.executeUpdate();

			if (count>0) {
				result = true;
			} else {
				result = false;
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("update의 sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}

	
	public  InventoryBean selectInven(InventoryBean inven) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getConnection();
			String sql = "select * from pmm where model=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, inven.getModel());

			rs = pstmt.executeQuery();

			if (rs.next()) {

				inven.setBnum(rs.getString("bnum"));
				inven.setPname(rs.getString("pname"));
				inven.setModel(rs.getString("model"));
				inven.setCompany(rs.getString("company"));
				inven.setCate(rs.getString("cate"));
				inven.setAmount(rs.getString("amount"));
				inven.setPrice(rs.getString("price"));

			}

		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("select sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}
		return inven;
	}


	public boolean addInven(InventoryBean inven) {

		Connection con = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		try {
			con = DBConnection.getConnection();
			String sql ="INSERT INTO pmm VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, inven.getBnum());
			pstmt.setString(2, inven.getPname());
			pstmt.setString(3, inven.getModel());
			pstmt.setString(4, inven.getCompany());
			pstmt.setString(5, inven.getCate());
			pstmt.setString(6, inven.getAmount());
			pstmt.setString(7, inven.getPrice());
		
			int count = pstmt.executeUpdate();

			if (count>0) 
				result = true;
			else {
				result = false;
			}

		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("add sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}

}

