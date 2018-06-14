<%@page import="java.sql.Date"%>
<%@page import="java.util.*"%>
<%@page import="org.gntp.*"%>
<%@page import="org.gntp.bodyService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:useBean id="body" class="org.gntp.Body"></jsp:useBean>
<jsp:useBean id="bs" class="org.gntp.bodyService" />
<jsp:setProperty property="*" name="body" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list of body</title>
</head>
<body>
	<hr>
	<center>
		<table border="1">
			<tr>
				<td>No</td>
				<td>체크일</td>
				<td>신장</td>
				<td>체중</td>
				<td>사용자ID</td>
				<td>작업</td>
			</tr>

			<%
				String option = request.getParameter("option");

				if (option == null || option.equals("")) {
					option = "all";
				}

				ArrayList<Body> list = null;
				Vector<String> item = null;

				list = bs.searchBody(body, option);

				if (list.size() == 0) {
					out.print("찾는 데이터가 없습니다.");
				}

				for (int i = 0; i < list.size(); i++) {
					body = list.get(i);

					String body_id = Integer.toString(body.getBody_id());
					String check_date = body.getCheck_date();
					float height = body.getHeight();
					float weight = body.getWeight();
					String member_id = body.getMember_id();
			%>

			<tr>
				<td align="center"><%=body_id%></td>
				<td><%=check_date%></td>
				<td><%=height%></td>
				<td><%=weight%></td>
				<td><%=member_id%></td>
				<td align="center">
				<a href="updateForm.jsp?body_id=<%=body_id%>">
				<img src="../images/check.png" title=수정></a> 
				<a href="deleteBody.jsp?body_id=<%=body_id%>"> 
				<img src="../images/error.png" title=삭제></a></td>
			</tr>

			<%
				}
			%>

			<tr>
				<td colspan="3" align="center">
					<form action="inputaddbody.jsp">
						<input type="submit" value="추가하기">
					</form>
				</td>
				<td colspan="3" align="center">
					<form action="updateBody.jsp" method="get">
						<input type="text" placeholder="member_id을 입력하세요" name=option>
						<button>search</button>
					</form>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>