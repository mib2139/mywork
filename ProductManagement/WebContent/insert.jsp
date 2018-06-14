<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.or.gntp.db.DBconnection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>정보 추가</title>
</head>
<body>

	<%
		// 쿼리문

			String model = request.getParameter("model");
			String madeby = request.getParameter("madeby");
			String sort = request.getParameter("sort");
			String amount = request.getParameter("amount");
			String total = request.getParameter("total");
			
			String query = "insert into pm values (?,?,?,?,?) ";
			
			int count = 0;
			
			// 커넥션 연결
			Connection conn = DBconnection.getConnection();

			// DB에 쿼리문을 보낸다.
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, model);
			pstmt.setString(2, madeby);
			pstmt.setString(3, sort);
			pstmt.setString(4, amount);
			pstmt.setString(5, total);
			
			// 쿼리문의 결과값을 rs에 담는다.
			count = pstmt.executeUpdate();
	%>

	<center>
		<form>
			<table>
				<tr align="center">
					<td colspan="2" align="center">추가하기</td>
				</tr>
				
				<tr align="center">
					<td>모델</td>
					<td><input type="text" name="modelfield"></td>
				</tr>
				
				<tr align="center">
					<td>제조사</td>
					<td><input type="text" name="madebyfield"></td>
				</tr>
				
				<tr align="center">
					<td>종류</td>
					<td><input type="text" name="sortfield"></td>
				</tr>
				
				<tr align="center">
					<td>수량</td>
					<td><input type="text" name="amountfield"></td>
				</tr>
				
				<tr align="center">
					<td>합계</td>
					<td><input type="text" name="totalfield"></td>
				</tr>
				
				<tr align="center">
					<td colspan="2" align="center" style="height: 17px;">
					<input type="submit" value="확인"  > </td>
				</tr>

			</table>
		</form>
	</center>
	
	<script type="text/javascript">

	if(<%=count%> > 0){

		alert("정상적으로 정보가 입력되었습니다");

	}else{

		alert("실패");

		history.go(-1);//이전페이지로 가기

	}

</script>
</body>
</html>