<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    *{
    box-sizing: border-box;
    }
</style>
</head>
<body>
<form id="update" action="doupdate.jsp" method="post" enctype="multipart/form-data">
     <% int num =Integer.parseInt(request.getParameter("list.get(0).getSeq()")); %>
<table border="1">
   <tr><th colspan="5" width=400>글 수정하기</th></tr>
   <tr> <td  align="center">제목 :</td> <td colspan="3"><input type="text" id="title" name="title"></td>
   <td  colspan="1"> 글번호 : <input type="text" id="index" name="seq" readonly> </td> </tr>
   <tr><td colspan="5"><textarea rows="30" cols="50" style="resize: none;" id="contents" name="contents"></textarea> </td></tr>
    <tr><td>첨부파일</td>
		<td>
			<input type="file" name="file">
		</td>
	</tr>
   <tr><td colspan="5" style="align-content:center;" align="center" >
   <button id="done">수정하기</button>
   <button id="cancle">취소</button> 
   </td></tr>
</table>
</form>

<script>
document.getElementById("index").value = <%=num%>;
document.getElementById("done").onclick = function(){
    document.getElementById("update").submit();
}
 document.getElementById("cancle").onclick = function(){
    
    location.href="list.jsp?list.get(i).getSeq()=<%=num%>";
 }
</script>
		<%
			
		%> 
</body>
</html>