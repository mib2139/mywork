<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="org.gntp.db.UearBean" scope="page"/>
<jsp:setProperty property="*" name="user"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 if(user.searchuser()){
	 out.print(user.getId()+"<br>");
	 out.print(user.getPw()+"<br>");
 }else{
	 out.print("다시 입력하세요");
 }
%>

</body>
</html>