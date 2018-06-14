<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신체 정보 입력 페이지</title>
</head>
<body>
	<center>
		<h1>신체 정보 입력</h1>
		<center>
			<hr>
			<form action="addbodyProcess.jsp" method="get"/>
				<table border="1" align="center">
				<tr align="center">
				<td>측정일</td>
				<td><input type="date" name="check_date"/></td>
				</tr>
				
				<tr align="center">
				<td>키</td>
				<td><input type="text" name="height"/></td>
				</tr>
				
				<tr align="center">
				<td>몸무게</td>
				<td><input type="text" name="weight"/></td>
				</tr>
				
				
				<tr align="center">
				<td>ID</td>
				<td><input type="text" name="member_id"/></td>
				</tr>
				
				<tr align="center">
				<td colspan="2">
				<input type="submit" value="입력하기"/>
				</td>
				</tr>
				
				
				</table>	
			</form>
</body>
</html>