<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sun.corba.se.pept.transport.InboundConnectionCache"%>
<%@page import="java.util.*"%>
<%@ page import="java.io.*" %>
<%@ page import="org.gntp.beans.*"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<jsp:useBean id="inven" class="org.gntp.beans.InventoryBean" scope="page"></jsp:useBean>
<jsp:useBean id="mb" class="org.gntp.beans.ManagementBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="inven" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%

	String model = inven.getModel();
	String path = "C:/Users/user42/eclipse-workspace/WBP3/WebContent/data/";

	File file = new File(path+model+".jpg");	
	
	System.out.print(model);
		
		if(mb.deleteinven(inven)){
			file.delete();
			System.out.println("파일 삭제됨");
		}else{
			System.out.println("파일 없음");
		}
		
		response.sendRedirect("3_Status.jsp");
 %>
</body>
</html>