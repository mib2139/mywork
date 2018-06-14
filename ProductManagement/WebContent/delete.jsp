<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.or.gntp.db.DBconnection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delete</title>
</head>
<body>
	<%
		String model = request.getParameter("model");
			String sql = "delete from pm where model =?";
			
			Connection conn = DBconnection.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
	       	pstmt.setString(1, model); 
	       	
	       	int count = pstmt.executeUpdate();
	       	
	       	if(count>0){ out.print("정상적으로 삭제 되었습니다");}
	       	else {out.print("삭제에 실패했습니다.");}
	%>
	<br>
	<br>

</body>
</html>