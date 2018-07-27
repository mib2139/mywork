<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@ page import="org.gntp.beans.*"%>

<jsp:useBean id="inven" class="org.gntp.beans.InventoryBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="inven"/>


<%
	String ssid = (String) session.getAttribute("id");
	
	if (ssid == null || ssid.equals(" ")) {
		response.sendRedirect("1_LoginMain.html");
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<link rel="stylesheet" media="all" href="style.css" />
<title>정보 수정</title>
</head>
<body>
	<center>
		<h1>ADD FORM</h1>
		<center>
			<center>
				<form action="8_1insertProcess.jsp" class="update_table">
					<table>

						<tr align="center">
							<td>모델</td>
							<td><input type="text" name="model"></td>
						</tr>

						<tr align="center">
							<td>제조사</td>
							<td><input type="text" name="madeby"></td>
						</tr>

						<tr align="center">
							<td>종류</td>
							<td><input type="text" name="sort"></td>
						</tr>

						<tr align="center">
							<td>수량</td>
							<td><input type="text" name="amount"></td>
						</tr>

						<tr align="center">
							<td>합계</td>
							<td><input type="text" name="total"></td>
						</tr>
						
						<tr align="center">
							<td>사진</td>
							<td><input type="file" name = "fileName"></a>
						</tr>
				
						<tr align="center">
							<td colspan="2" align="center" style="height: 17px;"><input
								type="submit" value="확인" style="width: 77px; height: 35px;">
							</td>
						</tr>
					</table>
				</form>
			</center>
</body>
</html>