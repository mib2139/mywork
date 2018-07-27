<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER ADD</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<form action="<%=request.getContextPath()%>/AddStudent.jsp"
		method="post">
		<div id="wrap">
			<table class="tbl_View">
				<caption>Student</caption>
				<colgroup>
					<col style="width: 30%" />
					<col style="width:;" />
				</colgroup>
				<tbody>
					<tr>
						<th>이름</th>
						<td><input name="name" type="text" size="63" maxlength="20" /></td>
					</tr>
					<tr>
						<th>국어점수</th>
						<td><input name="kok" type="text" size="63" maxlength="20" />
						</td>
					</tr>
					<tr>
						<th>영어점수</th>
						<td><input name="eng" type="text" size="63" maxlength="20" /></td>
					</tr>
					<tr>
						<th>수학점수</th>
						<td><input name="math" type="text" size="63" maxlength="20" /></td>
					</tr>
					<tr>
						<th>총 점</th>
						<td><input name="total" type="text" size="63" maxlength="20" hidden=""></td>
					</tr>
					<tr>
						<th>평균</th>
						<td><input name="avg" type="text" size="63" maxlength="30" hidden=""/></td>
					</tr>
	
				</tbody>
			</table>
			<div class="txt-rt mt20">
				<input type="button" value="저장" onclick="form.submit()" /> <input
					type="button" value="목록"
					onclick="location.href='<%=request.getContextPath()%>/ListStudent.jsp'" />
			</div>
		</div>
	</form>
</body>
</html>