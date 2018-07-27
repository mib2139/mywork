<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="org.gntp.db.UearBean" scope="page"/>
<jsp:setProperty property="model" name="user"/>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <form action="updateitemprocess.jsp" method="post">
  수정할 상품명:<input type="text" name="model" maxlength="10" value="<%=user.getModel()%>"><br>
  수정할 내용<br>
  변경할 수량:<input type="text" name="amount" maxlength="8">
  <input type="submit" value="수정">
 </form>
</body>
</html>