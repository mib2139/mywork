<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sun.corba.se.pept.transport.InboundConnectionCache"%>
<%@page import="java.util.*"%>
<%@ page import="org.gntp.beans.*"%>

<jsp:useBean id="inven" class="org.gntp.beans.InventoryBean"
	scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="inven" />

<%
	String ssid = (String) session.getAttribute("id");

	if (ssid == null || ssid.equals(" ")) {
		response.sendRedirect("1_LoginMain.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<link rel="stylesheet" media="all" href="./css/style.css" />
<title>삭제각</title>
</head>
<body>
	<center>
		<h1>정말로 삭제하시겠습니까 ?</h1>
		<center>

			<%
				
				ManagementBean mb = new ManagementBean();
				mb.selectInven(inven);
				String model = inven.getModel();
				String fileName1 = request.getParameter("model");
				
			%>

			<center>
				<form name="up" class="update_table" method="post" action="deleteService.jsp">
					<table>

						<tr>
							<td colspan="2">
							<img src="./data/<%=fileName1%>.jpg" width="300"></td>
						</tr>

						<tr align="center">
							<td>대리점</td>
							<td><input type="text" name="bnum"
								value="<%=inven.getBnum()%>" readonly></td>
						</tr>
						
						<tr align="center">
							<td>모델명</td>
							<td><input type="text" name="model"
								value="<%=inven.getModel()%>" readonly="readonly"></td>
						</tr>

						<tr align="center">
							<td colspan="2"><input type="submit" value="삭제" style="width: 77px; height: 35px;"/><br/>
						</tr>
					</table>
				</form>
			</center>
</body>
</html>