<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="org.gntp.LoginBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="login" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%if(!login.updateUser()){
out.println("찾는 레코드가 없습니다.");
}else{
out.println("수정이 완료되었습니다.");
} %>
</body>
</html>