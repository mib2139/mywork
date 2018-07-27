<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="us" class="com.javalec.upload.UserService"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 if(us.upload(request)){
	 response.sendRedirect("07_fieldsketch_gallery.html");
 }else{
	 out.print("실패");
 }
%>

</body>
</html>