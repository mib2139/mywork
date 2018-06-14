<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sun.corba.se.pept.transport.InboundConnectionCache"%>
<%@page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.gntp.beans.*"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<%
	String ssid = (String) session.getAttribute("id");

	if (ssid == null || ssid.equals(" ")) {
		response.sendRedirect("1_LoginMain.jsp");
	}
%>

<jsp:useBean id="member" class="org.gntp.beans.Member" scope="page"></jsp:useBean>
<jsp:useBean id="lb" class="org.gntp.beans.LoginBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="member" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<%
		String path = "C:/Users/user42/eclipse-workspace/WBP3/WebContent/data/";

		if (lb.deleteMember(member)) {
			File file = new File(path + ssid + ".jpg");
			file.delete();
			response.sendRedirect("1_LoginMain.jsp");

		} else {
			System.out.println("실패");
		}

	%>

</body>
</html>