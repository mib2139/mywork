package org.gntp;
import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;
import javax.naming.NamingException;
import org.gntp.db.*;

public class LoginBean {
	private String id ;
	private String pw ;	

	public LoginBean() {
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

	public boolean checkUser() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getConnection();
			String sql = "select * from member where id=? and pw=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,id);
			pstmt.setString(2,pw);

			rs = pstmt.executeQuery();

			if (rs.next()) 
				return true;
			else {
				return false;
			}

		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}
		return false;
	}


	public boolean addUser() {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = DBConnection.getConnection();
			String sql = "insert into member values (?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,id);
			pstmt.setString(2,pw);

			int count = pstmt.executeUpdate();

			if (count>0) 
				result = true;
			else {
				result = false;
			}

		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}
		return result;
	}

	public boolean updateUser() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		boolean result = false;

		try {
			con = DBConnection.getConnection();
			String sql = "update member set pw=? where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,pw);
			pstmt.setString(2,id);

			int count = pstmt.executeUpdate();

			if (count>0) {
				result = true;
			}else {
				result = false;
			}

		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}
		return result;

	}
	
	public boolean delUser() {	
	Connection con = null;
	PreparedStatement pstmt = null;
	boolean result = false;

	try {
		con = DBConnection.getConnection();
		String sql = "delete from member where id=?";
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1,id);
	
		int count = pstmt.executeUpdate();

		if (count>0) 
			result = true;
		else {
			result = false;
		}

	}catch (ClassNotFoundException e) {
		System.out.println("클래스 오류가 발생했습니다. ");
	}catch (SQLException e) {
		System.out.println("sql 오류가 발생했습니다. ");
	}catch (NamingException e) {
		System.out.println("클래스 오류가 발생했습니다. ");
	}
	return result;
}
	
	
	public boolean listUser() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		boolean result = false;
		
		try {
			con = DBConnection.getConnection();
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				this.pw = rs.getString("pw");
				result = true;
			}
			

		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}
		return result;
	}
	
	
	
	public boolean searchUser() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		boolean result = false;
		
		try {
			con = DBConnection.getConnection();
			String sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,id);
		
			rs = pstmt.executeQuery();

			if (rs.next()) { 
				this.pw = rs.getString("pw");
				result = true;
			} else {
				result = false;
			}

		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}
		return result;
	}
}
