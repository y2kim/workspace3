<%@page import="bean.ReplyInfo"%>
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
		  int num =Integer.parseInt(request.getParameter("list.get(0).getSeq()")); 
		  String ids = (String)session.getAttribute("loginId");
		  String getip = request.getRemoteAddr();
		  ReplyDAO rdao = new ReplyDAO();
		  ReplyInfo rifs = new ReplyInfo();
		  rifs.setArticle_no(num);
		  rifs.setWriter(ids);
		  rifs.setIp(getip);
		  rifs.setComment_text(request.getParameter("comment_text"));
		  int result = rdao.insertBorder(rifs);
		  if(result>0){%>
			  <script>
			      alert("댓글이 정상적으로 달렸습니다.");
			      location.href="list.jsp?list.get(i).getSeq()=<%=num%>";
			  </script>
		  <%}else{%>
			  <script>
			  	  alert("댓글이 실패했습니다.");
			  	  location.href="list.jsp?list.get(i).getSeq()=<%=num%>";
			  </script>
		  <%}%>
</body>
</html>