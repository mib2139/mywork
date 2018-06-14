
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="org.gntp.*"%>
<%@page import="org.gntp.bodyService"%>

<jsp:useBean id="body" class="org.gntp.Body"></jsp:useBean>
<jsp:useBean id="bs" class="org.gntp.bodyService" />
<jsp:setProperty property="*" name="body" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UPDATE PROCESS</title>
</head>
<body>
	<%
	
		 if (bs.updateBody(body)) {
			response.sendRedirect("updateBody.jsp");
		} else {
			out.print("실패");
		} 
	%>
</body>
</html>