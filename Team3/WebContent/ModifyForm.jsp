<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*, java.text.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER MODIFY FORM</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<%
	if (request.getParameter("num") == null) {
		response.sendRedirect(request.getContextPath() + "/ListCon.jsp");
	} else {
		String num = request.getParameter("num");
		String username = "";
		String title = "";
		String memo = "";
		String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
		String dbUser = "root";
		String dbPw = "user123456789";
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		String time = simpleDate.format(date);

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
			String selectSql = "SELECT * FROM team WHERE num=?";
			statement = connection.prepareStatement(selectSql);
			statement.setString(1, num);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {

				num = resultSet.getString("num");
				username = resultSet.getString("username");
				title = resultSet.getString("title");
				memo = resultSet.getString("memo");
				time = resultSet.getString("time");
				

			} else {
				response.sendRedirect(request.getContextPath() + "/Listcon.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("BOARD MODIFY FROM ERROR!");
		} finally {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
			try {
				statement.close();
			} catch (Exception e) {
			}
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
%>
<body>
	<form name="hmsForm" action="<%=request.getContextPath()%>/ModifyAction.jsp"
		method="post">
		<div id="wrap">
			<table class="tbl_View">
				<caption>Info</caption>
				<colgroup>
					<col style="width: 30%" />
					<col style="width:;" />
				</colgroup>
				<tbody>
					<tr>
						<th>번호</th>
						<td><input name="num" value="<%=num%>" type="text" size="63"
							maxlength="20" readonly="readonly" /></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input name="username" value="<%=username%>" type="text"
							size="63" maxlength="20" /></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input name="title" value="<%=title%>" type="text"
							size="63" maxlength="20" /></td>
					</tr>

					<tr>
						<th>수정 날짜</th>
						<td><input name="title" value="<%=time%>" type="text"
							size="63" maxlength="20" readonly="readonly" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="10" cols="10" name="memo"><%=memo%></textarea>
					</tr>
				</tbody>
			</table>
			<div class="txt-rt mt20">
				<input type="button" value="글저장" onclick="form.submit()" /> <input
					type="button" value="목록"
					onclick="location.href='<%=request.getContextPath()%>/ListCon.jsp'" />
			</div>
		</div>

	</form>
	<%
		}
	%>
</body>

</html>