<%@page import="java.util.*"%>
<%@page import="java.math.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Example</title>
</head>
<body>
   <%
      ArrayList<Vector> list = new ArrayList<Vector>();
      Vector<String> item = null;

      //페이지당 출력되는 글의 수 (=레코드의 수)
      int itemNum = 5;

      //전체 글의 갯수
      int totalNum = 99;

      //전체 페이지 수 
      int pageNum = (int) Math.ceil((float) totalNum / (float) itemNum);

      String str = request.getParameter("page");
      if (str == null) {
         str = "1";
      }
      
      //파라미터로 받은 페이지번호 
      int argPage = Integer.parseInt(str);

      //페이지 0부터 시작함.
      int page2 = argPage - 1;

      //페이지에서 글의 시작 숫자
      int startNo = page2 * 5;

      //페이지에서 글의 마지막 숫자 
   
      int endNo = startNo + 5;
      
      int lastNo = totalNum%5;
      
      if ((argPage == pageNum) && (lastNo != 0)) {
         endNo = startNo + lastNo;
      }

      for (int i = 0; i < totalNum; i++) {
         item = new Vector<String>();
         item.add(Integer.toString(i));
         item.add("핫");
         item.add("갸악");

         list.add(item);

      }
   %>
   <hr>
   <%
      for (int i = startNo; i < endNo; i++) {
         out.print(list.get(i) + "<br>");
      }
   %>
   <hr>
   <%if(argPage <=1 ){
      out.print("이전페이지없음");
   } else { %>
   <a href="Board.jsp?page=<%=argPage-1%>">이전페이지</a>
   <%}%>
   
   

   <%if(argPage>=20){
      out.print("다음페이지 없음 ");
   } else { %>
   <a href="Board.jsp?page=<%=argPage+1%>">다음 페이지 </a>   
   <%}%>


</body>
</html>