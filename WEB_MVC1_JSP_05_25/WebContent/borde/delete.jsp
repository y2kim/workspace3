<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="bean.ReplyDAO"%>
<%@page import="bean.FileDao"%>
<%@page import="bean.BoradDAO"%>
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
		   
		   String isid = (String)session.getAttribute("loginId");
		   int num =Integer.parseInt(request.getParameter("list.get(0).getSeq()")) ;
		   BoradDAO bdao = new BoradDAO();
		   FileDao fdao = new FileDao();
		   ReplyDAO rdao = new ReplyDAO();
		   String chkid = bdao.ischk(num);
		   if(isid.equals(chkid)){
		   List<String> lists = fdao.deleteTotalFileSystem(num);
		   int result = bdao.deleteList(num);
		   
		   int result2; 
		   try{
		   result2 =  rdao.deleteTotalReply(num); 
		   }catch(Exception E){
		    result2 = 0;
		   }
		   int result3 ;
		   String realPath = request.getServletContext().getRealPath("/files/");
		   
		   for(int i=0;i<lists.size();i++){
			   String filenames = lists.get(i);
			   String dir = realPath + filenames;
			   File cFile = new File(dir); 
			   try{ cFile.delete();}
			   catch(Exception E){
				   
			   }
		   }
		   try{
		   result3= fdao.deleteTotalFile(num);
		   }catch(Exception E){
			   result3 =0;
		   }
		   if(result > 0 && result2 > 0 && result3 >0){%>
		       <script>
			   alert("성공적으로 삭제되었습니다");
			   location.href="../BorderList.jsp";
			   </script> 
			   <%}else if(result > 0 && result2 >0 || result3 >0){%>
			   <script>
			   alert("성공적으로 글이 삭제되었습니다.");
			   location.href="../BorderList.jsp";
			   </script>
			   <%} else{%>
			   <script>
			   alert("실패하였습니다");
			   location.href="../BorderList.jsp";
			   </script> 
			  <% }%>
		   }else{
			   %><script>
			    alert("작성자가 아니면 접근하실수가 없습니다.");
			   </script> 
			   <%
		   	}
		   %>
		  
</body>
</html>