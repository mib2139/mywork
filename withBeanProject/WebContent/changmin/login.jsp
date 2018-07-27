<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="login" class="org.gntp.db.UearBean" scope="page"/>
<jsp:setProperty property="*" name="login"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 체크</title>
</head>
<body>
<% if(login.checkuser()){
%>
<script type="text/javascript">
 location.href="itemlist.jsp";
</script>
<%
}else{
%>
<script type="text/javascript">
 alert("로그인 실패 다시 입력하세요");
 location.href="index.html";
</script>
<%
}

%>

</body>
</html>