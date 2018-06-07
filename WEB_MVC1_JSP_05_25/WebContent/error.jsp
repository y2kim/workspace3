<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	잘 못된 접근입니다 <br>
	3초 후 자동으로 페이지가 이동됩니다 
	최종버전 배포할때에는 잘못된 경로로 들어올때에에는 돌려보내야 한다 
	<script>
		setTimeout(function() {
			location.href = "login.jsp";
		},3000);
	</script>
</body>
</html>