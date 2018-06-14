<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sun.corba.se.pept.transport.InboundConnectionCache"%>
<%@page import="java.util.*"%>
<%@ page import="org.gntp.beans.*"%>

<link href="https://fonts.googleapis.com/css?family=Caveat" rel="stylesheet">

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
		<h1>UPDATE FORM</h1>
		<center>

			<%
				
				ManagementBean mb = new ManagementBean();
				mb.selectInven(inven);
				String model = inven.getModel();
				String fileName1 = request.getParameter("model");
				
			%>

			<center>
				<form name="up" class="update_table" enctype="Multipart/form-data" method="post">
					<table>

						<tr>
							<td colspan="2"><img src="./data/<%=fileName1%>.jpg"
								width="300"></td>
						</tr>

						<tr align="center">
							<td>대리점</td>
							<td><input type="text" name="bnum"
								value="<%=inven.getBnum()%>" readonly></td>
						</tr>

						<tr align="center">
							<td>제품명</td>
							<td><input type="text" name="pname"
								value="<%=inven.getPname()%>"></td>
						</tr>

						<tr align="center">
							<td>모델명</td>
							<td><input type="text" name="model"
								value="<%=inven.getModel()%>" readonly="readonly"></td>
						</tr>

						<tr align="center">
							<td>제조사</td>
							<td><input type="text" name="company"
								value="<%=inven.getCompany()%>"></td>
						</tr>

						<tr align="center">
							<td>카테고리</td>
							<td><input type="text" name="cate"
								value="<%=inven.getCate()%>"></td>
						</tr>

						<tr align="center">
							<td>수량</td>
							<td><input type="text" name="amount"
								value="<%=inven.getAmount()%>"></td>
						</tr>

						<tr align="center">
							<td>가격</td>
							<td><input type="text" name="price"
								value="<%=inven.getPrice()%>"></td>
						</tr>

						<tr align="center">
							<td>사진</td>
							<td><input type="file" name="fileName1" /><br /> <input
								id="file" type="hidden" name="cmd" value="update" /><br />
						</tr>

						<tr align="center">
							<td colspan="2" align="center" style="height: 17px;">
								<button type="button" onclick="fileUpload()"
									style="width: 77px; height: 35px;">수정</button> 
							</a>
							</td>
						</tr>
					</table>
				</form>
			</center>
			
			<form action="deleteProcess.jsp?model=<%=inven.getModel() %>" method="post" style="padding-top: 10px">
				<input type="submit" value="삭제하기" style="width: 77px; height: 35px;">
				</form>
</body>
</html>