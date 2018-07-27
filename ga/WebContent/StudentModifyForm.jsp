<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER MODIFY FORM</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
 <script>
        function init(code){
                var form  = document.hmsForm;
                selectBox(form.dept, code);
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
        }
 </script>
<%
    if(request.getParameter("name") == null) {
        response.sendRedirect(request.getContextPath()+"/ListStudent.jsp");
    } else {
        String name = request.getParameter("name");
        String kok = "";
        String eng = "";      
        String math = "";
        String total = "";
        String avg = "";
       
    
        String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
        String dbUser = "root";
        String dbPw = "user123456789";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            String selectSql = "SELECT * FROM studentdb WHERE name=?";
            statement = connection.prepareStatement(selectSql);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                name = resultSet.getString("name");
                kok = resultSet.getString("kok");
                eng = resultSet.getString("eng");
                math = resultSet.getString("math");
                total = resultSet.getString("total");
                avg = resultSet.getString("avg");
            } else {
                response.sendRedirect(request.getContextPath()+"/ListStudent.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("BOARD MODIFY FROM ERROR!");
        } finally {
            try {resultSet.close();} catch(Exception e){}
            try {statement.close();} catch(Exception e){}
            try {connection.close();} catch(Exception e){}
        }
%>    
<body onload="javascript:init(<%=total%>)">
        <form name="hmsForm" action="<%=request.getContextPath()%>/StudentModifyAction.jsp" method="post">
<div id="wrap">
	<table class="tbl_View">
		<caption>Student</caption>
		<colgroup>
			<col style="width:30%" />
			<col style="width: ;" />
		</colgroup>
		<tbody>
			<tr>
				<th>이름</th>
				<td><input name="name" value="<%=name%>" type="text" size="63" maxlength="20" /></td>
			</tr>
			<tr>
				<th>국어성적</th>
				<td><input name="age" value="<%=kok%>" type="text" size="63" maxlength="20" /></td>
			</tr>
			<tr>
				<th>영어성적</th>
				<td><input name="phone" value="<%=eng%>" type="text" size="63" maxlength="20" /></td>
			</tr>
			<tr>
				<th>수학성적</th>
				<td><input name="email" value="<%=math%>" type="email" size="63" maxlength="30" /></td>
			</tr>
			<tr>
				<th>총점</th>
				<td><input name="address" value="<%=total%>" type="text" size="63" maxlength="20" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>평균</th>
				<td><input name="address" value="<%=avg%>" type="text" size="63" maxlength="20" readonly="readonly"/></td>
			</tr>
		</tbody>
	</table>
	<div class="txt-rt mt20">
        <input type="button" value="글저장" onclick="form.submit()"/>
        <input type="button" value="목록" onclick="location.href='<%=request.getContextPath()%>/StudentList.jsp'"/>
    </div>
</div>

        </form>
<%
    }    
%>
</body>

</html>