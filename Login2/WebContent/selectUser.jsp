<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<jsp:useBean id="login" class="org.gntp.LoginBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="login"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%if(login.searchUser()){%>
<jsp:getProperty name="login" property="id"/>
<jsp:getProperty name="login" property="pw"/>
<%}else{out.print("찾기 실패했다 ㅋ");} %><p>

</body>
</html>