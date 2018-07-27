<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER VIEW</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
 <script>
       /* function init(code){
                var form  = document.hmsForm;
                selectBox(form.title, code);
        }

        function selectBox(sel, val){
                var selOptions = sel.options;
                var size = selOptions.length;
                for(var i = 0; i<size; i++){
                        if(selOptions[i].value == val){
                                selOptions[i].selected = true;
                                break;
                        }
                }
        }*/
 </script>
<%
    if(request.getParameter("num") == null) {
        response.sendRedirect(request.getContextPath()+"/employeeList.jsp");
    } else {
        String num = request.getParameter("num");
        String dbUrl = "jdbc:mysql://localhost:3307/manager";
        String dbUser = "root";
        String dbPw = "1234";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            String sql = "SELECT * FROM teamboard1 WHERE num=?";
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
				<td><%=resultSet.getString("time")%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><%=resultSet.getString("memo")%></td>
			</tr>
		</tbody>
	</table>
	<div class="txt-rt mt20">
        <input type="button" value="목록" onclick="location.href='<%=request.getContextPath()%>/employeeList.jsp'"/>
        <input type="button" value="수정" onclick="location.href='<%=request.getContextPath()%>/employeeModifyForm.jsp?num=<%=num%>'"/>
        <input type="button" value="삭제" onclick="location.href='<%=request.getContextPath()%>/employeeRemoveAction.jsp?num=<%=num%>'"/>
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