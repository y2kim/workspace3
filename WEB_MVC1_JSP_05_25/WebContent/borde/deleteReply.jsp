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
		   int num =Integer.parseInt(request.getParameter("lister.get")) ;
		   int one =Integer.parseInt(request.getParameter("one")) ;
		   ReplyDAO rdao = new ReplyDAO();
		   int result = rdao.deleteReply(num);
		   if(result>0){%>
			   <script>
			     alert("성공적으로 삭제하였습니다.");
			     location.href="list.jsp?list.get(i).getSeq()=<%=one%>";
			   </script>
		   <%}else{%>
			   <script>
			     alert("삭제에 실패하였습니다.");
			     location.href="list.jsp?list.get(i).getSeq()=<%=one%>";
			   </script>
		   <%}
		%>
</body>
</html>