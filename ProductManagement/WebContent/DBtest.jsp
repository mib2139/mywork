<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.or.gntp.db.DBconnection"%> <!-- DB연결 클래스를 import한다. -->
<html>
 
<head>
</head>
<body>
    <center>
        <table border="3">
        <tr bgcolor="skyblue"><td>모델<td>제조사<td>종류<td>수량<td>합계</tr>
        
        <%
                	// 쿼리문
                        String query="select * from pm";
                        
                        // 커넥션 연결
                        Connection conn = DBconnection.getConnection();
                        
                        // DB에 쿼리문을 보낸다.
                        PreparedStatement pstmt = conn.prepareStatement(query);
                        
                        // 쿼리문의 결과값을 rs에 담는다.
                        ResultSet rs = pstmt.executeQuery();
                        
                        // 결과값을 출력한다.
                        while(rs.next()){
                            out.println("<tr>");
                            out.println("<td>"+rs.getString("model"));
                            out.println("<td>"+rs.getString("madeby"));
                            out.println("<td>"+rs.getString("sort"));
                            out.println("<td>"+rs.getString("amount"));
                             out.println("<td>"+rs.getString("total"));
                            out.println("</tr>");
                        }
                %>
        </table>
    </center>
</body>
</html>
