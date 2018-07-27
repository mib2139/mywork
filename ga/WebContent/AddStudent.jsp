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
    String name = request.getParameter("name");
    String kok = request.getParameter("kok");
    String eng = request.getParameter("eng");
    String math = request.getParameter("math");
    
    int kok2 = Integer.parseInt(kok);
    int eng2 = Integer.parseInt(eng);
    int math2 = Integer.parseInt(math);
    int total2 = kok2+eng2+math2;
  
    String total = String.valueOf(total2);
    String avg= String.valueOf(total2/3);
  
    String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
    String dbUser = "root";
    String dbPw = "user123456789";
    Connection connection = null;
    PreparedStatement statement = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        String sql = "INSERT INTO studentdb values(?,?,?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setString(2,kok);
        statement.setString(3,eng);
        statement.setString(4,math);
        statement.setString(5,total);
        statement.setString(6,avg);
        statement.executeUpdate();
        
      response.sendRedirect(request.getContextPath()+"/ListStudent.jsp");
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