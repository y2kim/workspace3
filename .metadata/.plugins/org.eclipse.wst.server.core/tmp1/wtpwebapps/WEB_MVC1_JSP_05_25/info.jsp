<%@page import="bean.MemberInfos"%>
<%@page import="java.util.List"%>
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
	if(session.getAttribute("loginId")==null){
		response.sendRedirect("error.jsp");
	}else{
		String getids =(String)session.getAttribute("loginId");
	    DAO date = new DAO();
	    List<MemberInfos> list = date.myinfo(getids);
	%>
  <table border="1">
    <tr>
      <td>ID:</td>
      <td><%=list.get(0).getId() %></td>
    </tr>
    <tr>
      <td>NAME:</td>
      <td><%=list.get(0).getName()%></td>
    </tr>
    <tr>
      <td>PHONE:</td>
      <td><%=list.get(0).getPhone1()+"-"+list.get(0).getPhone2()+"-"+list.get(0).getPhone3() %></td>
    </tr>
    <tr>
      <td>EMAIL:</td>
      <td><%=list.get(0).getEmail()%></td>
    </tr>
    <tr>
      <td>ADDRESS:</td>
      <td><%=list.get(0).getZipcode()+""+list.get(0).getAddress1()+list.get(0).getAddress2()%></td>
    </tr>
  </table>
  <button id="return" type="button">돌아가기</button>
  <script>
    document.getElementById("return").onclick = function(){
       location.href="login.jsp";
       //history.back() // 전페이지 go(2) <- 2페이지 전  
    }
  </script>
  <%} %>
</body>
</html>
