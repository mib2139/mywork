<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@ page import="org.gntp.beans.*"%>


<%
	String ssid = (String) session.getAttribute("id");

	if (ssid == null || ssid.equals(" ")) {
		response.sendRedirect("1_LoginMain.jsp");
	}
%>


<jsp:useBean id="inven" class="org.gntp.beans.InventoryBean"
	scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="inven" />

<link href="https://fonts.googleapis.com/css?family=Nanum+Myeongjo"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link rel="stylesheet" media="all" href="./css/style.css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STATUS-search</title>
</head>
<body>

	<div align="right">
		<%
			String id = (String) session.getAttribute("id");
			out.print(id);
		%>님 환영합니다. &ensp;&ensp;&ensp;
		<li><a href="Logout.jsp">로그아웃</a></li>
		<li><a href="UpdateMember.jsp">회원정보 변경</a></li>

	</div>


	<center>
		<h1>INVENTORY CHECK</h1>
	</center>

	<%
		ManagementBean mb = new ManagementBean();
		mb.selectInven(inven);
		String bnum = inven.getBnum();
		String model = inven.getModel();

		ArrayList<InventoryBean> list = null;
		list = mb.listInven(inven);

		Vector<String> item = null;
		ArrayList<Vector> pagelist = new ArrayList<Vector>();

		//페이지당 보여지는 회원의 수
		int itemNum = 5;
		//총 회원 수 
		int totalNum = list.size();
		//전체 페이지 수 
		int pageNum = (int) Math.ceil((float) totalNum / (float) itemNum);

		//처음시작할 때 page의 값을 1로 줌.
		String str = request.getParameter("page");
		if (str == null) {
			str = "1";
		}

		//파라미터로 받은 페이지번호 
		int argPage = Integer.parseInt(str);

		//글은 0부터 시작함.
		int page2 = argPage - 1;

		//페이지에서 처음시작하는 글의 번호
		int startNo = page2 * itemNum;

		//똑 떨어질때 페이지에서 글의 마지막 번호 
		int endNo = startNo + itemNum;

		//나누어서 떨어지지 않을 때 
		int lastNo = totalNum % itemNum;

		//만약 마지막 페이지일 때 lastNO이 0이 아니라면 (나머지값이 있다면) 
		//처음 시작하는 숫자 + 나머지 값을 더하면 똑 덜어지지 않아도,,오류가 안남
		if ((argPage == pageNum) && (lastNo != 0)) {
			endNo = startNo + lastNo;
		}
	%>

	<center>
		<table border="0" class="status_table"
			style="font-family: 'Nanum Myeongjo', serif">
			<tr style="width: 831px;">
				<td colspan="8" align="center">

					<form action="5_serch.jsp" style="align-items: center;">
						<input type="text" style="height: 43px; width: 346px"
							placeholder="모델명을 입력하세요" name="model">
						<button>search</button>
					</form>
				</td>

			</tr>

			<tr bgcolor="skyblue">
				<td>대리점번호</td>
				<td>제품번호</td>
				<td>모델명</td>
				<td>제조사</td>
				<td>카테고리</td>
				<td>수량</td>
				<td>가격</td>
			</tr>

			<tr>

				<td><a href="6_UpdateInven.jsp?model=<%=model%>"><%=bnum%></a></td>
				<td><%=inven.getPname()%></td>
				<td><%=inven.getModel()%></td>
				<td><%=inven.getCompany()%></td>
				<td><%=inven.getCate()%></td>
				<td><%=inven.getAmount()%></td>
				<td><%=inven.getPrice()%></td>

			</tr>
			<tr align="center">
				<td colspan="9"><a href="4_Status.jsp"><img alt="맨 앞으로"
						src="./img/double_left.png"></a> <%
 	if (argPage <= 1) {
 %> <img alt="이전" src="./img/right-arrow.png"
					style="width: 21px; height: 21px;"> <%
 	} else {
 %> <a href="4_Status.jsp?page=<%=argPage - 1%>"> <img
						alt="이전" src="./img/right-arrow.png"
						style="width: 21px; height: 21px;"></a> <%
 	}
 %> <%
 	if (argPage >= pageNum) {
 %> <img alt="다음" src="./img/left-arrow.png"
					style="width: 21px; height: 21px;"> <%
 	} else {
 %> <a href="4_Status.jsp?page=<%=argPage + 1%>"><img alt="이전"
						src="./img/left-arrow.png" style="width: 21px; height: 21px;"></a>
					<%
						}
					%> <a href="4_Status.jsp?page=<%=pageNum%>"><img alt="맨 뒤로"
						src="./img/double_right.png"></a></td>
			</tr>
			<tr align="right" style="height: 70px;" style="width: 130px;">
				<td colspan="8" style="height: 41px;">
					<form action="8_Insert.jsp" style="width: 125px;">
						<input type="submit" value="추가하기"
							style="background-color: skyblue; color: white; width: 86px; height: 38px; border: 0px">
					</form>
				</td>
			</tr>
		</table>
	</center>

</body>
</html>