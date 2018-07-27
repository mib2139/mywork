<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="org.gntp.beans.*"%>

<jsp:useBean id="inven" class="org.gntp.beans.InventoryBean"
	scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="inven" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ManagementBean mb = new ManagementBean();

		if (mb.addInven(inven)) {
			out.println("추가가 완료되었습니다.");
			response.sendRedirect("4_Status.jsp");
		} else {
			out.println("실패입니다.");
			response.sendRedirect("8_1insertProcess.jsp");
		}
	%>
</body>
</html>