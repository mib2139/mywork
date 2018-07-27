<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.gntp.beans.*" %>
<jsp:useBean id="member" class="org.gntp.beans.Member" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="member" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>탈퇴하기</title>
</head>
<body>
<%
		LoginBean ms = new LoginBean();

		if (ms.deleteMember(member)) {
			out.println("<script>alert('성공적으로 제거했습니다.')</script>");
			response.sendRedirect("1_LoginMain.html");
		} else {
			out.println("<script>alert('잘못입력하셨습니다.다시확인해주세요')</script>");
	
		}
	%>
</body>
</html>