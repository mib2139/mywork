<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.or.gntp.db.DBconnection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>정보 수정</title>
</head>
<body>

	<%
		// 쿼리문

			String model = request.getParameter("model");

			String query = "select * from pm where model = ? ";
			
			// 커넥션 연결
			Connection conn = DBconnection.getConnection();

			// DB에 쿼리문을 보낸다.
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, model);
			

			// 쿼리문의 결과값을 rs에 담는다.
			ResultSet rs = pstmt.executeQuery();
		
			rs.next();
	%>

	<center>
		<form>
			<table>
				<tr align="center">
					<td colspan="2" align="center">수정폼</td>
				</tr>
				
				<tr align="center">
					<td>모델</td>
					<td><input type="text" name="modelfield"
						value = "<%=rs.getString("model")%>"></td>
				</tr>
				
				<tr align="center">
					<td>제조사</td>
					<td><input type="text" name="madebyfield"
						value = "<%=rs.getString("madeby")%>"></td>
				</tr>
				
				<tr align="center">
					<td>종류</td>
					<td><input type="text" name="sortfield"
						value = "<%=rs.getString("sort")%>"></td>
				</tr>
				
				<tr align="center">
					<td>수량</td>
					<td><input type="text" name="amountfield"
						value = "<%=rs.getString("amount")%>"></td>
				</tr>
				
				<tr align="center">
					<td>합계</td>
					<td><input type="text" name="totalfield"
						value = "<%=rs.getString("total")%>"></td>
				</tr>
				
				<tr align="center">
					<td colspan="2" align="center" style="height: 17px;">
					<input type="submit" value="확인" > </td>
				</tr>

			</table>
		</form>
	</center>

</body>
</html>