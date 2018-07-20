<%@page import="com.sun.corba.se.pept.transport.InboundConnectionCache"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@page import="org.gntp.beans.*"%>

<jsp:useBean id="myfile" class="org.gntp.beans.Myfile2"></jsp:useBean>
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
<script type="text/javascript">
	function fileUpload() {
		document.up.action = "fileUpload.jsp";
		document.up.submit();
	}
</script>

<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<link rel="stylesheet" media="all" href="./css/style.css" />
<title>정보 수정</title>
</head>
<body>
	<center>
		<h1>INSERT FORM</h1>
		<center>

			<%
			
				//ManagementBean mb = new ManagementBean();
				//mb.selectInven(inven);
				String model = inven.getModel();
				//String fileName1 = request.getParameter("model");
				
			%>

			<center>
				<form name="up" class="update_table" enctype="Multipart/form-data" method="post">
					<table>
						<tr align="center">
							<td>대리점</td>
							<td><input type="text" name="bnum"></td>
						</tr>

						<tr align="center">
							<td>제품명</td>
							<td><input type="text" name="pname"></td>
						</tr>

						<tr align="center">
							<td>모델명</td>
							<td><input type="text" name="model"></td>
						</tr>

						<tr align="center">
							<td>제조사</td>
							<td><input type="text" name="company"></td>
						</tr>

						<tr align="center">
							<td>카테고리</td>
							<td><input type="text" name="cate"></td>
						</tr>

						<tr align="center">
							<td>수량</td>
							<td><input type="text" name="amount"></td>
						</tr>

						<tr align="center">
							<td>가격</td>
							<td><input type="text" name="price"></td>
						</tr>

						<tr align="center">
							<td>사진</td>
							<td>
							<input type="file" name="fileName1"/><br/> 
							<input type="hidden" name="cmd" value="insert"/><br/> 
						
						</tr>

						<tr align="center">
							<td colspan="2" align="center" style="height: 17px;">
							<button type="button" onclick="fileUpload()" style="width: 77px; height: 35px;">저장</button></td>
				
						</tr>
					</table>
				</form>
			</center>
</body>
</html>