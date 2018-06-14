package org.gntp;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.naming.*;
import org.gntp.db.DBConnection;
import java.text.*;

public class bodyService {

	public Body getBody (Body body) {
		return body;
	}

	//create
	public boolean addBody(Body body) throws ParseException {

		Connection con = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		String strdate = body.getCheck_date();
		Date date = Date.valueOf(strdate);

		try {

			con = DBConnection.getConnection();
			String sql = "insert into body(check_date, height, weight, member_id) values(?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setDate(1, date);
			pstmt.setFloat(2, body.getHeight());
			pstmt.setFloat(3, body.getWeight());
			pstmt.setString(4, body.getMember_id());

			int count = pstmt.executeUpdate();

			if (count>0) {
				result = true;
			} else {
				result = false;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql ������ �߻��߽��ϴ�. ");
		}catch (NamingException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
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


	//read-���̺� ���
	public ArrayList<Body> listBody(Body body) {
		//���ڵ��ϳ��� Body�̰� , ������ �ִ� ���� ArrayList�� .
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Body> list = new ArrayList<Body>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from body";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				body = new Body();

				body.setBody_id(rs.getInt("body_id"));
				body.setCheck_date(rs.getString("check_date"));
				body.setHeight(rs.getFloat("height"));
				body.setWeight(rs.getFloat("weight"));
				body.setMember_id(rs.getString("member_id"));

				list.add(body);
			}

		}catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
		}catch (SQLException e) {
			System.out.println("sql ������ �߻��߽��ϴ�. ");
		}catch (NamingException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}


	//search-Ư�� ���ڵ� ���(read-search)
	public ArrayList<Body> searchBody(Body body, String option) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Body> list = new ArrayList<Body>();

		try {
			conn = DBConnection.getConnection();
			String sql = null;

			if(option.equals("all")) {
				sql = "select * from body";
				pstmt = conn.prepareStatement(sql);
			}else if (option.equals(" ")) {
				System.out.println("�Է��ϼ���");
			}else {
				sql ="select * from body where member_id=?" ;
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, option);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				body = new Body();
				body.setBody_id(rs.getInt("body_id"));
				body.setCheck_date(rs.getString("check_date"));
				body.setHeight(rs.getFloat("height"));
				body.setWeight(rs.getFloat("weight"));
				body.setMember_id(rs.getString("member_id"));

				list.add(body);
			}

		}catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
		}catch (SQLException e) {
			System.out.println("sql ������ �߻��߽��ϴ�. ");
		}catch (NamingException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
		}

		return list;
	}


	//update
	public boolean updateBody(Body body) {
		Connection con = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		String strdate = body.getCheck_date();
		Date date = Date.valueOf(strdate);

		try {

			con = DBConnection.getConnection();
			String sql ="update body set check_date=?, height=?, weight=?, member_id=? where body_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, body.getCheck_date());
			pstmt.setFloat(2, body.getHeight());   
			pstmt.setFloat(3, body.getWeight());
			pstmt.setString(4, body.getMember_id());
			pstmt.setInt(5, body.getBody_id());

			int count = pstmt.executeUpdate();

			if (count>0) {
				result = true;
			} else {
				result = false;
			}

		}catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
		}catch (SQLException e) {
			System.out.println("sql ������ �߻��߽��ϴ�. ");
		}catch (NamingException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
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

	//delete
	public boolean deleteBody(Body body){
		Connection con = null;
		PreparedStatement pstmt = null;

		boolean result = false;

		try {

			con = DBConnection.getConnection();
			String sql ="delete from body where body_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, body.getBody_id());

			int count = pstmt.executeUpdate();

			if (count>0) {
				result = true;
			} else {
				result = false;
			}

		}catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
		}catch (SQLException e) {
			System.out.println("sql ������ �߻��߽��ϴ�. ");
		}catch (NamingException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
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


	public Body updateSearch(Body body) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;



		try {

			conn = DBConnection.getConnection();
			String sql = "select * from body where body_id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, body.getBody_id());

			rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println("���õ�");
				body.setBody_id(rs.getInt("body_id"));
				body.setCheck_date(rs.getString("check_date").toString());
				body.setHeight(rs.getFloat("height"));
				body.setWeight(rs.getFloat("weight"));
				body.setMember_id(rs.getString("member_id"));
			}else{
				System.out.println("���þȵ�");
			}



		}catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
		}catch (SQLException e) {
			System.out.println("sql ������ �߻��߽��ϴ�. ");
		}catch (NamingException e) {
			System.out.println("Ŭ���� ������ �߻��߽��ϴ�. ");
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn!= null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return body;
	}
}
