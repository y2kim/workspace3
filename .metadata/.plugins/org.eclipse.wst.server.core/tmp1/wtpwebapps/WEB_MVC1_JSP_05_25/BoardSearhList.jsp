<%@page import="bean.BorderInfos"%>
<%@page import="java.util.List"%>
<%@page import="bean.BoradDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		
	    int pages = Integer.parseInt(request.getParameter("pages"));
		
		BoradDAO bdao = new BoradDAO();

		String searchText = (String) request.getParameter("text");
	%>
	<table border="1">
		<tr>
			<th colspan="5" width=600>검색된 게시판</th>
		</tr>
		<tr height=50>
			<td width=25>index</td>
			<td width=40>제목</td>
			<td width=40>작성자</td>
			<td width=40>작성일</td>
			<td width=40>조회</td>
		</tr>
		<%
		int pageSize = 5;
        int max = pageSize * pages;
        int min = max - pageSize ;
		List<BorderInfos> list = bdao.searchBoardCut(searchText, max, min);
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
 		  <tr><td style="align-content:center;" align="center"> <%=bdao.getSearchPageNavi(pages, searchText)%> </td></tr>
 		  <tr><td><button id="back">이전</button></td></tr>
	</table>
	
	<script>
	   document.getElementById("back").onclick = function(){
	        location.href="BorderList.jsp?currentPage=1";
	    }
	</script>
</body>
</html>