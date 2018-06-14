<%@page import="java.util.*"%>
<%@page import="org.gntp.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String ssid = (String) session.getAttribute("id");
	out.print(ssid + "<br>");

	if (ssid == null || ssid.equals(" ")) {
		response.sendRedirect("Login.html");
	}
%>

<jsp:useBean id="member" class="org.gntp.Member2"></jsp:useBean>
<jsp:setProperty property="*" name="member" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		MemberService ms = new MemberService();
		ArrayList<Member2> list = null;
		Vector<String> item = null;
		ArrayList<Vector> pagelist = new ArrayList<Vector>();

		list = ms.listMember(member);

		/* for (int i = 0; i < list.size(); i++) {
			member = list.get(i);
			out.print(member.getId()+"/");
			out.print(member.getPw());
			out.print("<br>"); */

		/* 	
			out.print(list.get(i).getId()+"/");
			out.print(list.get(i).getPw());
			out.print("<br>");
			
			}
			 */

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


	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>비고</td>
		</tr>


		<tr>
			<%
				for (int i = startNo; i < endNo; i++) {
					member = list.get(i);
					String id = member.getId();
					String pw = member.getPw();
			%>
			<td><%=id%></td>
			<td><%=pw%></td>
			<td><a href="updateUser.html?id=<%=id%>">수정</a> <a
				href="delUser.jsp?id=<%=id%>">삭제</a></td>
		</tr>
		<%
			}
		%>
		
		<tr >
			<td><a href="listMember.jsp?">맨앞 페이지</a></td>
			<td><%if(argPage<=1){
			out.print("이전페이지");}else{%>
   			<a href="listMember.jsp?page=<%=argPage-1%>">이전페이지</a>
   			<%}%></td>
			<td><%if(argPage>=pageNum){ out.print("다음페이지 ");
   } else { %>
   <a href="listMember.jsp?page=<%=argPage+1%>">다음 페이지 </a>   
   <%}%></td>
			<td><a href="listMember.jsp?page=<%=pageNum%>">마지막 페이지 </a></td>
		</tr>
	</table>
	<a href="Logout.jsp">로그아웃</a>
</body>
</html>