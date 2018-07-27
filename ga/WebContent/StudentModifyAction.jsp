<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER MODIFY ACTION</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("name") == null) {
			response.sendRedirect(request.getContextPath() + "/ListStudent.jsp");
		} else {

			String name = request.getParameter("name");
			String kok = request.getParameter("kok");
			String eng = request.getParameter("eng");
			String math = request.getParameter("math");
			String total = request.getParameter("total");
			String avg = request.getParameter("avg");
		

			String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
			String dbUser = "root";
			String dbPw = "user123456789";
			Connection connection = null;
			PreparedStatement statement = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
				String selectSql = "UPDATE studentdb SET name=?, kok=?, eng=?, math=?, total=?, avg=? WHERE name=?";
				statement = connection.prepareStatement(selectSql);
				statement.setString(1, name);
				statement.setString(2, kok);
				statement.setString(3, eng);
				statement.setString(4, math);
				statement.setString(5, total);
				statement.setString(6, avg);
				statement.setString(7, name);
				statement.executeUpdate();
				response.sendRedirect("ListStudent.jsp?");
			} catch (Exception e) {
				e.printStackTrace();
				out.print("MODIFY ERROR!");
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
		}
	%>
</body>
</html>
