<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER REMOVE ACTION</title>
</head>
<body>
<%
    if(request.getParameter("num") == null) {
        response.sendRedirect(request.getContextPath()+"/customerList.jsp");
    } else {
        String id = request.getParameter("num");
        String dbUrl = "jdbc:mysql://localhost:3307/manager";
        String dbUser = "root";
        String dbPw = "1234";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            String sql = "DELETE FROM teamboard1 WHERE num=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            if(statement.executeUpdate()==1){
                response.sendRedirect(request.getContextPath()+"/employeeList.jsp");
            }
        } catch(Exception e) {
            e.printStackTrace();
            out.print("REMOVE ERROR!");
        } finally {
            try {statement.close();} catch(Exception e){}
            try {connection.close();} catch(Exception e){}
        }
    }
%>
</body>
</html>