<%@page import="bean.DAO"%>
<%@page import="bean.MemberInfos"%>
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
			String getids =(String)session.getAttribute("loginId");
		    MemberInfos mifs = new MemberInfos();
		    DAO data = new DAO();
		    mifs.setPw(request.getParameter("pw"));
		    mifs.setName(request.getParameter("name"));
		    mifs.setPhone1(request.getParameter("phone1"));
		    mifs.setPhone2(request.getParameter("phone2"));
		    mifs.setPhone3(request.getParameter("phone3"));
		    mifs.setEmail(request.getParameter("email"));
		    mifs.setZipcode(request.getParameter("zipcode"));
		    mifs.setAddress1(request.getParameter("address1"));
		    mifs.setAddress2(request.getParameter("address2"));

		    int result = data.updateMember(mifs, getids);

		    if(result >0) {
		    	 %>
		    	 <script>
		    	  alert("변경이 완료되었습니다.");
            location.href = 'login.jsp';
		    	 </script>
		    	 <%
		    }else{
		    	%>
		    	 <script>
		    	   alert("변경이 실패하였습니다.");
             location.href = 'login.jsp';  
		    	 </script>
		    	<%
		    }
		%>
</body>
</html>
