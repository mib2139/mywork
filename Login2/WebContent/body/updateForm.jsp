<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="org.gntp.*"%>
<%@page import="org.gntp.bodyService"%>

<jsp:useBean id="body" class="org.gntp.Body"></jsp:useBean>
<jsp:useBean id="bs" class="org.gntp.bodyService" />
<jsp:setProperty property="*" name="body" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UPDATE FORM</title>
</head>
<body>

	<%
		body = bs.updateSearch(body);
		String body_id = Integer.toString(body.getBody_id());
		String check_date = body.getCheck_date();
		float height = body.getHeight();
		float weight = body.getWeight();
		String member_id = body.getMember_id();
	%>


	<H1 align="center">UPDATE FORM</H1>
	<center>
		<form action="updateProcess.jsp">
			<table>
				<tr>
					<td align="center">NO</td>
					<td align="center"><input type="text" readonly="readonly"
						name="body_id" value="<%=body_id%>"></td>
				</tr>


				<tr>
					<td align="center">DATE</td>
					<td align="center"><input type="date" name="check_date"
						value="<%=check_date%>"></td>
				</tr>

				<tr>
					<td align="center">HEIGHT</td>
					<td align="center"><input type="text" name="height"
						value="<%=height%>"></td>
				</tr>

				<tr>
					<td align="center">WEIGHT</td>
					<td align="center"><input type="text" name="weight"
						value="<%=weight%>"></td>
				</tr>

				<tr>
					<td align="center">MEMBER_ID</td>
					<td align="center"><input type="text" name="member_id"
						value="<%=member_id%>"></td>
				</tr>

				<tr>
					<td align="center" colspan="2"><input type="submit"
						value="수정하기"></td>

				</tr>

			</table>
		</form>
	</center>
</body>
</html>