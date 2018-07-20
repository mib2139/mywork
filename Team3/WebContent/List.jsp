<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 LIST</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<%
		String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
		String dbUser = "root";
		String dbPw = "user123456789";
		Connection connection = null;
		PreparedStatement totalStatement = null;
		PreparedStatement listStatement = null;
		ResultSet totalResultSet = null;
		ResultSet listResultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);

			String listSql = "SELECT * FROM team";
			listStatement = connection.prepareStatement(listSql);
			listResultSet = listStatement.executeQuery();
	%>
	<div id="wrap">

		<table class="tbl_List">
			<form name=writeform method=post action="write_ok.jsp">
				<caption>
					<H1>게시판 List</H1>
				</caption>
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
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>11</td>
						<td>22</td>
						<td>33</td>
					</tr>

					<tr>
						<td>11</td>
						<td>22</td>
						<td>33</td>
					</tr>
					<%
						while (listResultSet.next()) {
					%>
					<tr>
						<td><a
							href="<%=request.getContextPath()%>/View.jsp?id= 
          <%=listResultSet.getInt("no")%>">


								<%=listResultSet.getInt("no")%>
						</a></td>
						<td><%=listResultSet.getString("writer")%></td>
					</tr>
					<%
						}
					%>
				
			</form>

			</tbody>
		</table>
		<p>
			<td><input type=button value="글쓰기"
				OnClick="window.location='teamwriter.jsp'"></td>
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