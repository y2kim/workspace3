<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

		<table border="1">
				<tr>
				<td>index
				<td>이름
				<td>메세지
				</tr>
		 	<c:forEach var="items" items="${result}">
		 		<tr>
		 		 <td>${items.message_id}
		 		 <td>${items.name}
		 		 <td>${items.message}
		 		</tr>
		 	</c:forEach>
		 	<tr>
		 	<td><button id="back">돌아가기</button></td>
		 	</tr>
		</table>
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script>
			$("#back").click(function() {
				$(location).attr("href","index.html");
			})
		</script>
</body>
</html>