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


    <c:if test="${5<10}">
    	test 결과 true가 나온다면 이 내용이 출력됩니다 
    </c:if>
	<c:choose>
	     else if 대체재 
		<c:when test="ture">
		   첫번째가 출력
		</c:when>
		<c:when test="false">
		   두번째는 출력 되지 않을것 
		</c:when>
		<c:otherwise>
		  모두 False 일 경우 이 내용이 출력될것
		</c:otherwise>
	</c:choose>
		<table border="1">
		<c:forEach var="item" items="${result}">
		 <tr>
			<td>${item.seq}<br>
			<td>${item.name}<br>
			<td>${item.email}<br>
		 </tr>
		</c:forEach>
		</table>
		<!--  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" : 라는 접두사를 사용하겠다는 뜻 	 -->
</body>
</html>