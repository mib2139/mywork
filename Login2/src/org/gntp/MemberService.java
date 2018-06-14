package org.gntp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.*;

import org.gntp.db.*;

public class MemberService {

	public Member2 getMember(Member2 member) {
		return member;
	}

	public boolean addMember(Member2 member) {

		Connection con = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		try {
			con = DBConnection.getConnection();
			String sql = "insert into member values (?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());

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



	public boolean delMember(Member2 member) {
		Connection con = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		try {
			con = DBConnection.getConnection();
			String sql = "delete from member where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getId());

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

	public boolean UpdateMember(Member2 member) {		
		Connection con = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		try {
			con = DBConnection.getConnection();
			String sql = "update member set pw=? where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getId());

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


	public ArrayList<Member2> listMember(Member2 member) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Member2> list = new ArrayList<Member2>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from member";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				member = new Member2();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				
				list.add(member);
				
			}

		}catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}

		return list;
	}

	public boolean checkLogin(Member2 member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		boolean result = false;

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from member where id = ? and pw=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}catch (SQLException e) {
			System.out.println("sql 오류가 발생했습니다. ");
		}catch (NamingException e) {
			System.out.println("클래스 오류가 발생했습니다. ");
		}
		return result;
	}
	
	
	
}