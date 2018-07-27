<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STUDENT LIST</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String driver = "com.mysql.jdbc.Driver"; //데이터 베이스에 맞는 드라이브
		String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
		String dbUser = "root";
		String dbPw = "user123456789";
		Connection connection = null;
		PreparedStatement totalStatement = null;
		PreparedStatement listStatement = null;
		ResultSet totalResultSet = null;
		ResultSet listResultSet = null;
		try {

			Class.forName(driver);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);

			String listSql = "SELECT * FROM studentdb";
			listStatement = connection.prepareStatement(listSql);
			listResultSet = listStatement.executeQuery();
	%>
	<div id="wrap">

		<table class="tbl_List">
			<caption>Board</caption>
			<colgroup>
				<col style="width: 9%" />
				<col style="width: 16%" />
				<col style="width: 16%" />
				<col style="width: 13%" />
				<col style="width: 11%" />
				<col style="width:;" />
			</colgroup>
			<thead>
				<tr>
					<th>이름</th>
					<th>국어</th>
					<th>영어</th>
					<th>수학</th>
					<th>총점</th>
					<th>평균</th>
				</tr>
			</thead>
			<tbody>
				<%
					while (listResultSet.next()) {
				%>
				<tr>
					<td><a
						href="StudentModifyForm.jsp?name=<%=listResultSet.getString("name")%>">
							<%=listResultSet.getString("name")%>
					</a></td>
					<td><%=listResultSet.getInt("kok")%></td>
					<td><%=listResultSet.getInt("eng")%></td>
					<td><%=listResultSet.getInt("math")%></td>
					<td><%=listResultSet.getInt("total")%></td>
					<td><%=listResultSet.getInt("avg")%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<p>
		<div class="txt-rt mt20">
			<input type="button" value="학생추가"
				onclick="location.href='<%=request.getContextPath()%>/AddStudentForm.jsp'" />
		</div>
	</div>
	<%
		} catch (Exception e) {
			e.printStackTrace();
			out.print("목록 가져오기 실패!");
		} finally {
			try {
				listResultSet.close();
			} catch (Exception e) {
			}
			try {
				listStatement.close();
			} catch (Exception e) {
			}
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	%>
</body>
</html>