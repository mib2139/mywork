<%@page import="sun.nio.cs.HistoricallyNamedCharset"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="org.gntp.beans.LoginBean"%>

<jsp:useBean id="member" class="org.gntp.beans.Member" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="member" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login.check</title>
</head>
<body>

	<%
		LoginBean ms = new LoginBean();

		if (ms.checkMember(member)) {
			session.setAttribute("id", member.getId());
			session.setAttribute("pw", member.getPw());
			out.println("<script>alert('회원님 환영합니다.')</script>");
			response.sendRedirect("3_Status.html");
		} else {
			out.println("<script>alert('잘못입력하셨습니다.다시확인해주세요')</script>");
			response.sendRedirect("1_LoginMain.html");
		}
	%>

</body>
</html>