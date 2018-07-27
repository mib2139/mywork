<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@ page import="org.gntp.beans.*"%>


<%
	String ssid = (String) session.getAttribute("id");
	
	if (ssid == null || ssid.equals(" ")) {
		response.sendRedirect("1_LoginMain.html");
	}
%>


<jsp:useBean id="inven" class="org.gntp.beans.InventoryBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="inven" />

<link href="https://fonts.googleapis.com/css?family=Nanum+Myeongjo"	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link rel="stylesheet" media="all" href="style.css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STATUS</title>
</head>
<body>
<center><h1>Status Check</h1></center>
	
	<%
		ManagementBean mb = new ManagementBean();
		ArrayList<InventoryBean> list = null;

		list = mb.listInven(inven);
	
	%>

	<center>
		<table border="0" class="status_table" style="font-family: 'Nanum Myeongjo', serif">
			<tr style="width: 831px; ">
				<td colspan="6">
					
					<form action="5_serch.jsp">
						<input type="text" style=" height: 43px" placeholder="모델명을 입력하세요" name="model">
						<button>search</button>
					</form>
					
				</td>

			</tr>

			<tr bgcolor="skyblue">
				<td>모델</td>
				<td>제조사</td>
				<td>종류</td>
				<td>수량</td>
				<td>가격</td>
				<td>비고</td>
				<td>제품사진</td>
			</tr>

			<tr>
				<%for(int i = 0; i < list.size(); i++) {
					inven = list.get(i);
					String model = inven.getModel();
					String madeby = inven.getMadeby();
					String sort = inven.getSort();
					String amount = inven.getAmount();
					String total = inven.getTotal();
					
 					
 					%>
				<td><%= model %></td>
				<td><%= madeby %></td>
				<td><%= sort %></td>
				<td><%= amount %></td>
				<td><%= total %></td>
				<td><a href="7_delete.jsp?model=<%=model%>">삭제</a>
					<a href="6_UpdateInven.jsp?model=<%=model%>">수정</a></td>
				<td><form action="fileUpload.jsp"><input type="file" name = "fileName">
					<input type="submit" value="저장"></form></td>
			</tr>

			<%
				}
			%>
			<tr style="width: 966px; ">
				<td colspan="6">
					<form action="8_Insert.jsp" style="width: 856px; ">
						<input type="submit" value="추가하기"
							style="width: 849px; height: 44px">
					</form>
				</td>

			</tr>
		</table>
	</center>
	<a href="Logout.jsp">로그아웃</a>
</body>
</html>