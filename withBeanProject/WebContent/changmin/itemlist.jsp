<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>   
 
<jsp:useBean id="user" class="org.gntp.db.UearBean" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table align="center" border="1">

		<tr>
			<td colspan="6" align="center">재고 목록</td>
		</tr>
		<tr>
			<td align="center">모델명</td>
			<td align="center">제조사</td>
			<td align="center">분류</td>
			<td align="center">입고수량</td>
			<td align="center">가격</td>
			<td align="center">작업</td>
		</tr>
		
<% 
ArrayList<Vector> list = new ArrayList<Vector>();
Vector<String> item = new Vector<String>();

list = user.itemlist();

for(int i=0; i<list.size(); i++){
	item = list.get(i);
%>		
		
		<tr>
<%
for(int j=0; j<item.size(); j++){
	

%>
		    <td><%=item.get(j) %></td>
		    
<% 
}
%>
			<td><a href="itemupdate.jsp?model=<%= item.get(0)%>">수정</a>
				<a href="deluser.jsp?model=<%= item.get(0)%>">삭제</a></td>
		</tr>
<%
}
%>		
		
		<tr>
			<td colspan="6" align="right"><a href="additem.html">물품추가</a></td>
		</tr>
	</table>
</body>
</html>