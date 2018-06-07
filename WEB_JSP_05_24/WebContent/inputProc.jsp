<%@page import="kh_web_beans.PersonInfo"%>
<%@page import="kh_web_beans.PersonInfos"%>
<%@page import="kh_web_beans.PersonDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Input Process</title>
</head>
<body>

	<%
	    PersonInfo pif = new PersonInfo();
	    pif.setName(request.getParameter("name"));
	    pif.setPhone(request.getParameter("phone"));
	    pif.setEmail(request.getParameter("email"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		PersonDAO dao = new PersonDAO();
		int result = dao.insertData(pif);
	%>
	<script>
		if (<%=result%>> 0) {
			alert("ok");
		} else {
			alert("fail");
		}
		location.href = 'index.html';
	</script>
</body>
</html>