<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
				<c:forEach var="items" items="${list}">
			<tr>
			<td>${items.seq}
			<td> <a href="ListBoard?pagenum=${items.seq}">${items.title}</a>
			<td>${items.writer}
			<td>${items.writedate}
			<td>${items.viewcount}
			</tr>
		</c:forEach>
		<tr><td style="align-content:center;" align="center">${paging } </td></tr>
 		  <tr><td><button id="back">이전</button></td></tr>
     </table>
</body>
</html>