<%@page import="bean.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
        <%  request.getRemoteAddr();
            out.write(request.getParameter("id"));
            String ids = request.getParameter("id");
            if(ids.equals("")||ids.equals(null)){
            	%><script> alert("������ �����մϴ�");
            	close();
            	</script><%
            }
            DAO data = new DAO();
            boolean cando = data.chkIdMem(ids);
            
            if(cando){
            	%><script>
            	alert("��밡���� ���̵� �Դϴ�!");
            	opener.document.getElementById("inid").value = '<%=ids%>';
            	opener.document.getElementById("okid").value ="ok";
            	close();
            	</script> <% 
            }else{
            	%><script>alert("���Ұ����� ���̵� �Դϴ�!");
            	opener.document.getElementById("inid").value = "";
            	opener.document.getElementById("okid").value = "";
            	close();
            	</script><%
            }
        %>
</body>
</html>