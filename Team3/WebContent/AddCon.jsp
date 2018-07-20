<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*, java.text.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%
		java.util.Date date = new java.util.Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = simpleDate.format(date);

		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		String username = request.getParameter("username");
		String title = request.getParameter("title");
		String memo = request.getParameter("memo");
		String time = strdate;

		String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
		String dbUser = "root";
		String dbPw = "user123456789";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
			String sql = "INSERT INTO team(num, username, title, memo, time) values(?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, num);
			statement.setString(2, username);
			statement.setString(3, title);
			statement.setString(4, memo);
			statement.setString(5, time);

			statement.executeUpdate();

			response.sendRedirect(request.getContextPath() + "/ListCon.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("입력 예외 발생");
		} finally {
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
</body>
</html>