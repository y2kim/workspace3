<%@page import="bean.ReplyDAO"%>
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
		request.setCharacterEncoding("utf-8");
		   int num =Integer.parseInt(request.getParameter("lister.get")) ;
		   int one =Integer.parseInt(request.getParameter("one")) ;
		   ReplyDAO rdao = new ReplyDAO();
		%>
		<form action="replyModifyDo.jsp?mod=<%=num%>&one=<%=one%>" method="post" id="fix">
		<input type="text" name="comment_text">
		<button id="mod">수정</button><button id="can">취소</button>
		</form>
		<script>
		 document.getElementById("mod").onclick = function(){
		     alert("수정하였습니다");
		     document.getElementById("fix").submit();
		 }
		 document.getElementById("can").onclick = function(){
			 alert("취소하였습니다.");
			 location.href="list.jsp?list.get(i).getSeq()=<%=one%>";
	     }
		</script>
</body>
</html>