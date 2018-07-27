<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER LIST</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    String dbUrl = "jdbc:mysql://localhost:3307/manager";
    String dbUser = "root";
    String dbPw = "1234";
    Connection connection = null;
    PreparedStatement totalStatement = null;
    PreparedStatement listStatement = null;
    ResultSet totalResultSet = null;
    ResultSet listResultSet = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbUrl, 
        		dbUser, dbPw);
        
    String listSql = "SELECT * FROM teamboard1";
    listStatement = connection.prepareStatement(listSql);
    listResultSet = listStatement.executeQuery();
%>
<div id="wrap">

	<table class="tbl_List">
		<caption>Board</caption>
		<colgroup>
			<col style="width:9%" />
			<col style="width:16%" />
			<col style="width:16%" />
			<col style="width:20%" />
			<col style="width:40%" />
			<col style="width: ;" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성날짜</th>
			</tr>
		</thead>
		<tbody>
<%
            while(listResultSet.next()) {
%>
          <tr>
          <td><a href="<%=request.getContextPath()%>/employeeView.jsp?num= 
          <%=listResultSet.getString("num")%>">
          <%=listResultSet.getInt("num")%>
          </a>
          </td>
            <td><%=listResultSet.getString("username")%></td>
            <td><%=listResultSet.getString("title") %></td>
            <td><%=listResultSet.getString("memo") %></td>
            <td><%=listResultSet.getString("time") %></td>
                </tr>
<%      }  %>
        </tbody>
    </table>
    <p>
    	<div class="txt-rt mt20">
		<input type="button" value="학생추가" 
		onclick="location.href=
		'<%=request.getContextPath()%>/employeeAddForm.jsp'"/>
		</div>
</div>
<%
    } catch(Exception e) {
        e.printStackTrace();
        out.print("목록 가져오기 실패!");
    } finally {
        try {listResultSet.close();} catch(Exception e){}
        try {listStatement.close();} catch(Exception e){}
        try {connection.close();} catch(Exception e){}
    }
%>
</body>
</html>