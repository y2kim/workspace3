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
			<th colspan="5" width=600>자유게시판</th>
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
		        <tr>
            <td colspan="5" align="center">
            
            <input type="Button" value="작성하기" id="addtext">
            </td>
        </tr>
        <tr>
        <td>
        <td ><input type="text" name="text" id="searchText"></td>
        <td><button type="button" id="search">검색</button></td>
        </tr>
        <tr><td style="align-content:center;" align="center">
         ${paging }</td></tr>
	</table>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script>
		$("#addtext").click(function() {
			$(location).attr("href","write.board");
		})
		$("#search").click(function() {
		    var subtext = $("#searchText").val();
			$(location).attr("href","search.board?text="+subtext+"&pages=1");
		})
	</script>	
</body>
</html>