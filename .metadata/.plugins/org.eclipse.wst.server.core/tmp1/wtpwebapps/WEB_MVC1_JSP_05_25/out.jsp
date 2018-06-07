<%@page import="bean.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String getids =(String)session.getAttribute("loginId");
    	DAO date = new DAO();
	%>
	<table border="1">
		<tr>
			<td colspan="2">탈퇴하시겠습니까?</td>
		</tr>
		<tr>
			<td><button id="sure">예</button></td>
			<td><button id="cancle">아니오</button></td>
		</tr>
	</table>
	<script>
  document.getElementById("sure").onclick = function(){
      <% 
      int result = date.deleteMember(getids); 
      if(result > 0){
    	  session.invalidate();
    	 %> alert("정상적으로 탈퇴가 되었습니다"); 
    	    location.href="login.jsp"; 
    	 <%
      }else{
    	%> 
    	alert("정상적으로 탈퇴가 되었습니다"); 
    	location.href="login.jsp";  <%
      }
      %>
   }
  document.getElementById("cancle").onclick = function(){
    location.href="login.jsp";
  }
	</script>
</body>
</html>
