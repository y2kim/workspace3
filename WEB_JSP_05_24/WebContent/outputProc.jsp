<%@page import="java.util.List"%>
<%@page import="kh_web_beans.PersonDAO"%>
<%@page import="kh_web_beans.PersonInfos"%>
<%@page import="java.sql.ResultSet"%>
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
<title>Insert title here</title>
<style>
     #tablestyle{
          margin: auto;
          text-align: center;
     }
     #home{
     	  margin: auto;
     	  text-align: center;
     	  display: block;
     }
</style>
</head>
<body>
	<table border=1 id="tablestyle">
	<tr><td>index</td> <td>이름</td> <td>전화</td> <td>이메일</td></tr>
		<%
		PersonDAO dao = new PersonDAO();
		List<PersonInfos> lists = dao.selectData();
		int linesize = lists.size();
		for(int i=0;i<linesize;i++){
					%>
					<tr>
					<td><%=lists.get(i).getIds()%></td>
					<td><%=lists.get(i).getName()%></td>
					<td><%=lists.get(i).getPhone()%></td>
					<td><%=lists.get(i).getEmail()%></td>
					</tr>
					<%
		}
		%>
	</table>
<input type="button" value="return" onclick="location.href='index.html'" id="home">
</body>
</html>