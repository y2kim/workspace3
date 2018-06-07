<%@page import="bean.ReplyDAO"%>
<%@page import="bean.ReplyInfo"%>
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
		   int num =Integer.parseInt(request.getParameter("mod")) ;
		   int one =Integer.parseInt(request.getParameter("one")) ;
		   String contents = (String)request.getParameter("comment_text");
		   ReplyDAO rdao = new ReplyDAO();
		   int result = rdao.modifyReply(contents,num);
		   if(result >0){%>
			   <script>
			   alert("수정이 완료되었습니다");
			   location.href="list.jsp?list.get(i).getSeq()=<%=one%>";
			   </script>
		  <%}else { %>
		  <script>
			   alert("수정이 실패하였습니다.");
			   location.href="list.jsp?list.get(i).getSeq()=<%=one%>";
			 </script>
		<%} %>
</body>
</html>