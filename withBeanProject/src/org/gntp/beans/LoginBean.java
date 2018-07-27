package org.gntp.beans;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.naming.NamingException;

import org.gntp.*;
import org.gntp.db.*;

public class LoginBean {

	public Member getMember(Member member) {
		return member;
	}

	public boolean checkMember(Member member) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		boolean result = false ;

		try {

			conn = DBConnection.getConnection();

			String sql = "Select * from member where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true;
			}else {
				result = false;
			}

		} catch (SQLException e) {
			System.out.println("SQL 오류");

		} catch (NamingException e) {
			System.out.println("NAMEING 오류");

		} catch (ClassNotFoundException e) {
			System.out.println("CLASSNOTFOUND 오류");
		}
		return result;
	}


	public boolean addMember(Member member) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		try{

			conn = DBConnection.getConnection();
			String sql = "insert into member values(?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());

			int count = pstmt.executeUpdate();

			if (count>0) {
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
	
	
	
	public boolean deleteMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
		
			conn = DBConnection.getConnection();
			String sql = "delete from member where id=? and pw =?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			
			int count = pstmt.executeUpdate();
			
			if (count>0) {
				result = true;
			}else {
				result = false;
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("sql 오류가 발생했습니다. ");
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
}