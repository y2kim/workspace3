<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="bean.DAO"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String id =(String)request.getParameter("id");
		String pw =(String)request.getParameter("pw");
		boolean chklogin =  data.chklogin(id, pw);
		//session.setAttribute(arg0, arg1);
		
		if(chklogin){
			session.setAttribute("loginId", id);
			%>
			<script>
			 alert('<%=id%>'+" 로그인 성공");
			 location.href ='login.jsp';
			</script>
			<%
		}else{
			%>
			<script>
			 alert("로그인 실패하였습니다");
             location.href ='login.jsp';
			</script>
			<%
		}
	%>
</body>
</html>
