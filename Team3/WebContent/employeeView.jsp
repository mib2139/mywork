<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER VIEW</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<%
    if(request.getParameter("num") == null) {
        response.sendRedirect(request.getContextPath()+"/ListCon.jsp");
    } else {
        String num = request.getParameter("num");
        String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
        String dbUser = "root";
        String dbPw = "user123456789";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            String sql = "SELECT * FROM team WHERE num=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, num);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
%>
<body onload="javascript:init(<%=resultSet.getString("title")%>)">
<form name="hmsForm">
<div id="wrap">
	<table class="tbl_View">
		<caption>Student</caption>
		<colgroup>
			<col style="width:30%" />
			<col style="width: ;" />
		</colgroup>
		<tbody>
			<tr>
				<th>번호</th>
				<td><%=num%></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=resultSet.getString("username")%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<%=resultSet.getString("title") %>
				</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td><input type="datetime" value="<%=resultSet.getString("time")%>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><%=resultSet.getString("memo")%></td>
			</tr>
		</tbody>
	</table>
	<div class="txt-rt mt20">
        <input type="button" value="목록" onclick="location.href='<%=request.getContextPath()%>/ListCon.jsp'"/>
        <input type="button" value="수정" onclick="location.href='<%=request.getContextPath()%>/ModifyForm.jsp?num=<%=num%>'"/>
        <input type="button" value="삭제" onclick="location.href='<%=request.getContextPath()%>/RemoveAction.jsp?num=<%=num%>'"/>
    </div>
</div>
<%
            }
        } catch(Exception e) {
            e.printStackTrace();
            out.println("VIEW ERROR!");
        } finally {
            try {resultSet.close();} catch(Exception e){}
            try {statement.close();} catch(Exception e){}
            try {connection.close();} catch(Exception e){}
        }
    }
%>
</form>
</body>
</html>