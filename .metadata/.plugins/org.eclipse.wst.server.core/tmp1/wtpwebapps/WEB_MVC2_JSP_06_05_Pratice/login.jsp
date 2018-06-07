<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
}

div {
	border: 1px solid black;
}

#wrapper {
	width: 275px;
	height: 100px;
  margin: auto;
}

#col1 {
	width: 100%;
	height: 25%
}

#col2 {
	width: 100%;
	height: 25%
}

#col3 {
	width: 100%;
	height: 25%
}

#col4 {
	width: 100%;
	height: 25%
}

#indexid {
	height: 100%;
	width: 35%;
	float: left;
	text-align: center;

}

#inid {
	height: 100%;
	width: 65%;
	float: left;
}

#indexpwd {
	height: 100%;
	width: 35%;
	float: left;
	text-align: center;

}

#inpwd {
	height: 100%;
	width: 65%;
	float: left;
}

#textid {
	width: 100%;
	height: 100%;
}

#textpwd {
	width: 100%;
	height: 100%;
}
#joinmember{
  width: 100%;
  height: 35%;
  text-align: center;

}
#funclist{
  width: 100%;
  height: 65%;
}
#funclist button{
  width: 20%;
  border: 0px;
}
div button {
	border-top: 5px;
}
</style>
</head>
<body>
	<c:choose>
	<c:when test="${id!=null}">
	<div id="wrapper">
    <div id="joinmember">
       ${id}님 환영합니다
    </div>
    <div id="funclist">
      <button type="button" id="logout">로그아웃</button>
      <button type="button" id="mypage">나의페이지</button>
      <button type="button" id="memberout">회원탈퇴</button>
      <button type="button" id="modify">정보수정</button>
        <button type="button" id="borad">보드</button>
    </div>
        <button id="admin" type="button">회원관리</button>
  </div>
  <script>
  		document.getElementById("logout").onclick = function(){
        location.href="logout.jsp";
      }
      document.getElementById("mypage").onclick = function(){
        location.href="info.jsp";
      }
      document.getElementById("memberout").onclick = function(){
        location.href="out.jsp";
      }
      document.getElementById("modify").onclick = function(){
        location.href="modify.jsp";
      }
      document.getElementById("borad").onclick = function(){
          location.href="BoardList";
        }
      document.getElementById("admin").onclick = function(){
			location.href="admin/admin.jsp";
		}
  </script>
	</c:when>
	<c:when test="${id==null}">
	<form method="post" action="Login" id="logininfo">
		<div id="wrapper">
			<div id="col1" style="text-align: center">
				회원로그인
			</div>
			<div id="col2">
				<div id="indexid">아이디:</div>
				<div id="inid">
					<input type="text" id="textid" name="id">
				</div>
			</div>
			<div id="col3">
				<div id="indexpwd">비밀번호 :</div>
				<div id="inpwd">
					<input type="text" id="textpwd" name="pw">
				</div>
			</div>
			<div id="col4" style="text-align: center">
				<button id="log" type="button">로그인</button>
				<button id="sign" type="button" >회원가입</button>
			</div>
		</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script>
		$("#log").click(function() {
			 $("#logininfo").submit();
		})
		$("#sign").click(function() {
			location.href="join.html";
		})
	</script>	
	</c:when>
	</c:choose>
</body>
</html>