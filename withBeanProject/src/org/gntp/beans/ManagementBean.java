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
			String sql = "select * from pm";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				inven = new InventoryBean();

				inven.setModel(rs.getString("model"));
				inven.setMadeby(rs.getString("madeby"));
				inven.setSort(rs.getString("sort"));
				inven.setAmount(rs.getString("amount"));
				inven.setTotal(rs.getString("total"));

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
			String sql = "delete from pm where model=?";
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
			String sql = "update pm set madeby=?, sort=?, amount=?, total=? where model=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, inven.getMadeby());
			pstmt.setString(2, inven.getSort());
			pstmt.setString(3, inven.getAmount());
			pstmt.setString(4, inven.getTotal());
			pstmt.setString(5, inven.getModel());

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

	public InventoryBean selectInven(InventoryBean inven) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			String sql = "select * from pm where model=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, inven.getModel());
		
			rs = pstmt.executeQuery();

			if (rs.next()) {
			
				inven.setModel(rs.getString("model"));
				inven.setMadeby(rs.getString("madeby"));
				inven.setSort(rs.getString("sort"));
				inven.setAmount(rs.getString("amount"));
				inven.setTotal(rs.getString("total"));
		
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
			String sql = "insert into pm values (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, inven.getModel());
			pstmt.setString(2, inven.getMadeby());
			pstmt.setString(3, inven.getSort());
			pstmt.setString(4, inven.getAmount());
			pstmt.setString(5, inven.getTotal());
			
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

