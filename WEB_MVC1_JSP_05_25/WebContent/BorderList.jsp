<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.BorderInfos"%>
<%@page import="bean.BoradDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <style>

  </style>
<title>Insert title here</title>

</head>
<body>
         <%
         	   int currentpage = 0;
         	   try{ 
               currentpage =Integer.parseInt(request.getParameter("currentPage"));
         	   }catch(Exception e){
         		  currentpage=0; 
         	   }
         	   
               if(currentpage == 0){
            	   currentpage =1;
               }else{
            	   currentpage =Integer.parseInt(request.getParameter("currentPage"));
               }
                BoradDAO bdao = new BoradDAO();
         %>
<table border="1">
        <tr >
            <th colspan="5" width=600>자유게시판</th>
        </tr>
        <tr height=50>
            <td width=25>index</td>
            <td width=40>제목</td>
            <td width=40>작성자</td>
            <td width=40>작성일</td>
            <td width=40>조회</td>
        </tr>
        	<%	
        	     int totalborde = bdao.allBoard();
           		 int pageSize = 3;

                  int max = pageSize * currentpage;
                  int min = max - pageSize ;
        	    List<BorderInfos> list = bdao.listBordercut(max, min);; 
        	    for(int i=0;i<list.size();i++){
        	%>
		<tr>	
			<td><%=list.get(i).getSeq()%></td>
			<td><a href="borde/list.jsp?list.get(i).getSeq()=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle()%></a></td>
			<td><%=list.get(i).getWriter()%></td>
			<td><%=list.get(i).getWritedate()%></td>
			<td><%=list.get(i).getViewcount()%></td>
		</tr>
        		<%} %>
        <tr>
            <td colspan="5" align="center">
            
            <input type="Button" value="작성하기" id="addtext">
            </td>
        </tr>
        <tr>
        <td>
        <td colspan="4"><input type="text" name="search" id="searchText"></td>
        <td><button type="button" id="search">검색</button></td>
        </tr>
        <tr><td style="align-content:center;" align="center"> <%=bdao.getPageNavi(currentpage)%> </td></tr>
    </table>
    
    <script>
      document.getElementById("addtext").onclick = function(){
        location.href="borde/addbordetitle.html";
       }
      document.getElementById("search").onclick = function(){
    	  var subtext = document.getElementById("searchText").value;
          location.href="BoardSearhList.jsp?text="+subtext+"&pages=1";
       }
    </script>
</body>
</html>
