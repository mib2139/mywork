<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="org.gntp.*"%>
<%@page import="org.gntp.bodyService"%>

<jsp:useBean id="body" class="org.gntp.Body"></jsp:useBean>

<jsp:setProperty property="*" name="body" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>



	<%
		bodyService bs = new bodyService();

		if (bs.deleteBody(body)) {
			response.sendRedirect("updateBody.jsp");
		} else {
			response.sendRedirect("updateBody.jsp");
		}
	%>

</body>
</html>