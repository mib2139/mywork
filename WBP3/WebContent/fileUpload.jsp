<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>

<jsp:useBean id="myfile" class="org.gntp.beans.Myfile2"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
	String path = "C:/Users/user42/eclipse-workspace/WBP3/WebContent/data";
	int size = 10;

	myfile.upload(path, request);
	
	response.sendRedirect("3_Status.jsp");
%>
