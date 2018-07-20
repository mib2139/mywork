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
    if(request.getParameter("id") == null) {
        response.sendRedirect(request.getContextPath()+"/customerList.jsp");
    } else {
        String num = request.getParameter("num");
        String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
        String dbUser = "root";
        String dbPw = "user123456789";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            String sql = "DELETE FROM employee WHERE num=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, num);
            if(statement.executeUpdate()==1){
                response.sendRedirect(request.getContextPath()+"/ListCon.jsp");
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