<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.or.gntp.db.DBconnection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userlist</title>
</head>
<body>
	<%
		String driver = "org.mariadb.jdbc.Driver"; //데이터 베이스에 맞는 드라이브
		String url = "jdbc:mariadb://localhost:3307/manager"; //mydb
		String db_id = "root"; //그냥 새로운 개정 안 만들어서 그냥 root씀.
		String db_pw = "user123456789"; //위에 놓는 이유 쉽게 찾기 위해서 

		Connection con = null;//데이터 베이스까지의 연결
		PreparedStatement pstmt = null; //sql 전송을 하기 위한
		ResultSet rs = null;//데이터베이스에서 처리한 내용을 받아옴

		try {

			//드라이버 로딩
			Class.forName(driver);

			con = DriverManager.getConnection(url, db_id, db_pw); //

			if (con != null) {
				out.println("데이터 베이스 접속 성공"+"<br>");
			}

			String sql = "select * from member";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				out.print(rs.getString("id")+" "+rs.getString("pw")+" "+rs.getString("name")+"<br>");
				out.println();

			}

		} catch (ClassNotFoundException e) {
			out.println(driver + "드라이버 실패");
		} catch (SQLException e) {
			out.println("데이터 베이스 접속 실패");
		}
	%>
	<br>
	<br>

</body>
</html>