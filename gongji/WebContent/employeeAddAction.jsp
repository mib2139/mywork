<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String depart = request.getParameter("depart");
    String age = request.getParameter("age");
    String kok = request.getParameter("kok");
    String math = request.getParameter("math");
    String eng = request.getParameter("eng");
    String dbUrl = "jdbc:mysql://localhost:3307/manager";
    String dbUser = "root";
    String dbPw = "1234";
    Connection connection = null;
    PreparedStatement statement = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        String sql = "INSERT INTO student(id, name, depart, age, kok, math, eng) values(?,?,?,?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1,id);
        statement.setString(2,name);
        statement.setString(3,depart);
        statement.setString(4,age);
        statement.setString(5,kok);
        statement.setString(6,math);
        statement.setString(7,eng);
        statement.executeUpdate();
        
      response.sendRedirect(request.getContextPath()+"/employeeList.jsp");
    } catch(Exception e) {
        e.printStackTrace();
        out.print("입력 예외 발생");
    } finally {
        try {statement.close();} catch(Exception e){}
        try {connection.close();} catch(Exception e){}
    }
%>
</body>
</html>