<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="org.gntp.db.UearBean" scope="page"/>
<jsp:setProperty property="*" name="login"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="searchg.jsp" method="post">
  아이디:<input type="text" name="model" maxlength="10">
  <input type="submit" value="검색">
 </form>
</body>
</html>