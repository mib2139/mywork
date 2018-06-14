<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.gntp.LoadData"%>

<jsp:useBean id="ld" class="org.gntp.LoadData" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="ld" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoadData</title>
</head>
<body>
	<%
	
	String fileName1 = request.getParameter("fileName1");
	
	String fileName = "C:\\Users\\user42\\eclipse-workspace\\Login2\\WebContent\\data\\"+fileName1;
	ld.readFile(fileName);
	%>
	
</body>
</html>