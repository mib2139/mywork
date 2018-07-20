<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER MODIFY ACTION</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    if(request.getParameter("num") == null) {
        response.sendRedirect(request.getContextPath()+"/ListCon.jsp");
    } else {
        String num = request.getParameter("num");
        String username = request.getParameter("username");
        String title = request.getParameter("title");
        String memo = request.getParameter("memo");
    
        String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
        String dbUser = "root";
        String dbPw = "user123456789";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            String selectSql = "UPDATE team SET username=?, title=?, memo=? WHERE num=?";
            statement = connection.prepareStatement(selectSql);
            statement.setString(1,username);
            statement.setString(2,title);
            statement.setString(3,memo);
            statement.setString(4, num);
            statement.executeUpdate();
            response.sendRedirect(request.getContextPath()+"/employeeView.jsp?num="+num);
        } catch(Exception e) {
            e.printStackTrace();
            out.print("MODIFY ERROR!");
        } finally {
            try {statement.close();} catch(Exception e){}
            try {connection.close();} catch(Exception e){}
        }
    }
%>
</body>
</html>
