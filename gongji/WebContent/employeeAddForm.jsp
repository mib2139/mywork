<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER ADD</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="<%=request.getContextPath()%>/employeeAddAction.jsp" method="post">
<div id="wrap">
	<table class="tbl_View">
		<caption>Employee</caption>
		<colgroup>
			<col style="width:30%" />
			<col style="width: ;" />
		</colgroup>
		<tbody>
			<tr>
				<th>번호</th>
				<td><input name="num" type="text" size="63" maxlength="20" /></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
				 <input name="username" type="text" size="63" maxlength="20"/>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input name="title" type="text" size="63" maxlength="20" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="20" name="memo"></textarea> </td>
			</tr>
		</tbody>
	</table>
	<div class="txt-rt mt20">
        <input type="button" value="글저장" onclick="form.submit()"/>
        <input type="button" value="목록" onclick="location.href='<%=request.getContextPath()%>/employeeList.jsp'"/>
    </div>
</div>
</form>
</body>
</html>