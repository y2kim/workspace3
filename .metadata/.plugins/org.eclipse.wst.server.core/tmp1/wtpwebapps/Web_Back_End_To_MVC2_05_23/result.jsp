<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
		<c:choose>
	     
		<c:when test="${result>0}">
		<script >
		   alert("succed.");
		   location.href="index.html";
		</script>
		</c:when>
		<c:when test="${result<=0}">
		  <script >
		   alert("fail");
		   location.href="index.html";
		</script>
		</c:when>
		
	</c:choose>
</body>
</html>