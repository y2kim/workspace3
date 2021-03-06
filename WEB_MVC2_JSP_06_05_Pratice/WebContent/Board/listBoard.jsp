<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.id==writer}">
			<table border="1">
				<tr>
					<th colspan="5" width="400">${listBoard[0].title}</th>
				</tr>
				<tr>
					<td colspan="2">${listBoard[0].ip}</td>
					<td colspan="2">${listBoard[0].writer}</td>
					<td colspan="1">${listBoard[0].viewcount}
					<td>
				</tr>
				<tr height="400">
					<td colspan="5">${listBoard[0].contents}</td>
				</tr>
				<c:forEach var="reply" items="${relist}">
					<tr>
						<td>${reply.writer}</td>
						<td colspan="2">${reply.comment_text}</td>
						<td>${reply.ip}</td>
						<td>작성날짜 ${reply.writerdate}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<button id="back">뒤로</button>
					</td>
					<td>${page}</td>
				</tr>
			</table>
			<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
			<script>
				$("#back").click(function() {
					var pages = "${page}";
					location.href = "BoardList?currentPage=" + pages + ""
				})
			</script>
		</c:when>

		<c:when test="${sessionScope.id!=writer}">
			<table border="1">
				<tr>
					<th colspan="5" width="400">${listBoard[0].title}</th>
				</tr>
				<tr>
					<td colspan="2">${listBoard[0].ip}</td>
					<td colspan="2">${listBoard[0].writer}</td>
					<td colspan="1">${listBoard[0].viewcount}
					<td>
				</tr>
				<tr height="400">
					<td colspan="5">${listBoard[0].contents}</td>
				</tr>
				<c:forEach var="reply" items="${relist}">
					<tr>
						<td>${reply.writer}</td>
						<td colspan="2">${reply.comment_text}</td>
						<td>${reply.ip}</td>
						<td>작성날짜 ${reply.writerdate}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<button id="back">뒤로</button>
					</td>
				</tr>
				<tr>
					<td>${page}</td>
				</tr>

			</table>
			<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
			<script>
				$("#back").click(function() {
					var pages = "${page}";
					location.href = "BoardList?currentPage=" + pages + ""
				})
			</script>
		</c:when>
	</c:choose>
</body>
</html>