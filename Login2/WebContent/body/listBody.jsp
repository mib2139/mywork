<%@page import="java.sql.Date"%>
<%@page import="java.util.*"%>
<%@page import="org.gntp.*"%>
<%@page import="org.gntp.bodyService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="bs" class="org.gntp.bodyService"></jsp:useBean>
<jsp:useBean id="body" class="org.gntp.Body"></jsp:useBean>
<jsp:setProperty property="*" name="body" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list of body</title>
</head>
<body>

	<form method="get" action="listBody.jsp">
		<input type="text" name="option">
		<button>search</button>
	</form>

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

			out.print("Body_id:" + body.getBody_id() + "<br>");
			out.print("Check_date:" + check_date + "<br>");
			out.print("Height:" + height + "<br>");
			out.print("Weight:" + weight + "<br>");
			out.print("Member_id:" + member_id + "<br>");
	%>
	<hr>
	<%
		//out.print(list.get(i).getId()+"/");
			//out.print(list.get(i).getPw());
			//out.print("<br>");

		}
	%>



</body>
</html>