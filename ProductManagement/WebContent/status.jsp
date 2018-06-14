<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.or.gntp.db.DBconnection"%>
<!-- DB연결 클래스를 import한다. -->
<html>

<head>
</head>
<body>
	<%
		// 쿼리문
			String query = "select * from pm";

			// 커넥션 연결
			Connection conn = DBconnection.getConnection();

			// DB에 쿼리문을 보낸다.
			PreparedStatement pstmt = conn.prepareStatement(query);

			// 쿼리문의 결과값을 rs에 담는다.
			ResultSet rs = pstmt.executeQuery();
	%>

	<center>
		<table border="3">
			<tr bgcolor="skyblue">
				<td>모델</td>
				<td>제조사</td>
				<td>종류</td>
				<td>수량</td>
				<td>합계</td>
				<td>비고</td>

			</tr>
			<%while(rs.next()){ %>
			<tr>
				<td><%=rs.getString("model")%></td>
				<td><%=rs.getString("madeby")%></td>
				<td><%=rs.getString("sort")%></td>
				<td><%=rs.getString("amount")%></td>
				<td><%=rs.getString("total")%></td>
				<td><a href="delete.jsp?model=<%=rs.getString("model")%>">삭제</a> 
				<a href="update.jsp?model=<%=rs.getString("model")%>">수정</a></td>
			</tr>

			<%} %>
		<p>
		</table>
			<form action="insert.jsp">
			<input type="submit" value="추가하기">
			</form>
	</center>
</body>
</html>