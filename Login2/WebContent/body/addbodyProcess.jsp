<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@page import="org.gntp.bodyService"%>

<jsp:useBean id="bs" class="org.gntp.bodyService" scope="page"></jsp:useBean>
<jsp:useBean id="body" class="org.gntp.Body" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="body" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addbodyProcess.jsp</title>
</head>
<body>

	<%
		if(bs.addBody(body)){
		out.print("가입 성공");
		response.sendRedirect("updateBody.jsp");
		}else{
		out.print("가입 실패");
		}
	%>

</body>
</html>