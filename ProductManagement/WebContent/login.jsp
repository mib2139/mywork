<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.or.gntp.db.DBconnection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>


	<center>
	<%
		String id = request.getParameter("id");
			String pw = request.getParameter("pw");	
		    String sql = "select * from member where id=? and pw =?";
			
			Connection conn = DBconnection.getConnection();
		  
	       	// DB에 쿼리문을 보낸다.
	       	PreparedStatement pstmt = conn.prepareStatement(sql);
	       	pstmt.setString(1, id); 
	       	pstmt.setString(2, pw);
	       	 
	        // 쿼리문의 결과값을 rs에 담는다.
	       	ResultSet rs = pstmt.executeQuery();

			if (rs.next()){
		out.println("사용자 입니다");
		out.println(id+"님 환영합니다");}
			else{
		out.println("사용자가 아닙니다. 다시 시도하세용");}
	%>
	<br>
	<br>
</center>
</body>
</html>