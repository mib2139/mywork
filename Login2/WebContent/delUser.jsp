<%@page import="org.gntp.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<jsp:useBean id="member" class="org.gntp.Member2" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="member" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
		MemberService ms = new MemberService();

		if (ms.delMember(member)) {
			out.print("삭제 성공");
		} else {
			out.print("삭제 실패");
		}
	%>
	<p>

</body>
</html>