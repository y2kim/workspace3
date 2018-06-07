<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       권한이 없습니다 <br>
	3초 후 자동으로 페이지가 이동됩니다 
	관리자에게 문의 하십시오
	<script>
		setTimeout(function() {
			location.href = "../login.jsp";
		},3000);
	</script>
</body>
</html>