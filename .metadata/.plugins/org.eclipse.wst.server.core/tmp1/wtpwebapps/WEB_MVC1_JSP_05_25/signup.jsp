<%@page import="bean.MemberInfos"%>
<%@page import="bean.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="mifs" class="bean.MemberInfos">
   <jsp:setProperty name="mifs" property="*"/>
</jsp:useBean>  
<jsp:useBean id="data" class="bean.DAO"></jsp:useBean>
<!-- use Bean == DAO data = new DAO(); 와 동일  -->
<!-- <jsp:setProperty\ > ==  request.getParameter("id") 프론트 네임과  DTO id가 동일해야함 // param  -->
<!-- 위의 방식일 경우 DB와  프론트 컬럼명의 이름이 같아야 함   디폴트 생성자  -->
<!-- action 태크의 정확한 코드를 인식  종료태그를 축약할수 있다  -->
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <% 
       
       //MemberInfos mifs = new MemberInfos();
       int result = data.insertMember(mifs);
       String names = mifs.getName();
     %> 
     <script>

		if (<%=result%> > 0) {
			alert('<%=names%>'+"님 축하합니다 회원가입 되셨습니다!!!!!");
		} else {
			alert("fail");
		}
		location.href = 'login.jsp';  
     </script>
</body>
</html>