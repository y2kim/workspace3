<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	리스트 :  ${list[0] } : ${list[1] } <br>
	맵 :  ${map.one },   ${map.two } <br>
	${map["one"] },   ${map["two"] }  <br>
	빈     : ${car.price}, ${car.carName == "Tico"}, ${car["brand"] != GM} <br>
	${3+5} ${5<10} <Br>
	${name} <Br>
	${sessionScope.name} <br>
	<br>
	bean은 get이 있어야 함 
	모델2에서는 프론트 엔드 전문으로 바뀌게 된다 <br>
	절대주소를 가지고 있어서 보안성을 가지지만 공유를 하기가 힘들다  <br>
	작은 request 부터 올라 온다   작은 스코프 부터 올라온다  <br>
	<script>
	if(${result} >0){
		alert("입력에 성공하였습니다.")
	}else{
		alert("입력에 실패하였습니다.")
	}
	    //location.href="input.html"
		</script>

</body>
</html>