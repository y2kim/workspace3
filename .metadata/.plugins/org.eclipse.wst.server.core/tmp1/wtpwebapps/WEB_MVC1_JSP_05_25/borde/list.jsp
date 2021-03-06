<%@page import="bean.FileInfos"%>
<%@page import="bean.FileDao"%>
<%@page import="bean.ReplyInfo"%>
<%@page import="bean.ReplyDAO"%>
<%@page import="bean.BorderInfos"%>
<%@page import="java.util.List"%>
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
		int num = Integer.parseInt(request.getParameter("list.get(i).getSeq()"));
		String isid = (String) session.getAttribute("loginId");
		BoradDAO bdao = new BoradDAO();
		String hadid = bdao.ischk(num);
		if (isid.equals(hadid)) {
		} else {
			bdao.updateVisite(num);
		}
		List<BorderInfos> list = bdao.showGetPage(num);
		String iswriter = list.get(0).getWriter();

		if (iswriter.equals((String) session.getAttribute("loginId"))) {
	%>


	<table border="1">
		<tr>
			<th colspan="5" width="400"><%=list.get(0).getTitle()%></th>
		</tr>
		<tr>
			<td colspan="2"><%=list.get(0).getIp()%></td>
			<td colspan="2"><%=list.get(0).getWriter()%></td>
			<td colspan="1"><%=list.get(0).getViewcount()%></td>
		</tr>

		<tr height="400">
			<td colspan="5"><%=list.get(0).getContents()%></td>
		</tr>

		<%
			ReplyDAO rdao = new ReplyDAO();
				List<ReplyInfo> listre = rdao.showReply(num);

				for (int i = 0; i < listre.size(); i++) {
					if (!(isid.equals(listre.get(i).getWriter()))) {
		%>
		<tr>
			<td><%=listre.get(i).getWriter()%></td>
			<td colspan="2"><%=listre.get(i).getComment_text()%></td>
			<td><%=listre.get(i).getIp()%></td>
			<td>작성날짜 <%=listre.get(i).getWriterdate()%></td>
		</tr>
		<%
			} else {
		%>
		<tr>
			<td><%=listre.get(i).getWriter()%></td>
			<td colspan="2"><%=listre.get(i).getComment_text()%></td>
			<td><button id="redel">삭제</button> <button id="remod">수정</button></td>
			<td>작성날짜 <%=listre.get(i).getWriterdate()%></td>
		</tr>
		 <script>
            document.getElementById("redel").onclick = function(){
            	var del = confirm("삭제하시겠습니까?")
          	  if(del == true){
          		  location.href="deleteReply.jsp?lister.get=<%=listre.get(i).getComment_seq()%>&one=<%=num%>";
          	  } else {
  		    	  alert("취소하였습니다");
 		       }
		    }
            document.getElementById("remod").onclick = function(){
 		       location.href="replyModify.jsp?lister.get=<%=listre.get(i).getComment_seq()%>&one=<%=num%>";
 		    }
          </script>
		<%
			}
		%>
		<%
			}
		%>
         
		<form
			action="reply.jsp?list.get(0).getSeq()=<%=list.get(0).getSeq()%>"
			method="post" id="re">
			<tr>
				<td colspan="3"><input type="text" id="replytext"
					name="comment_text"></td>
				<td colspan="2" align="center"><button id="reply" type="button">댓글쓰기</button></td>
			</tr>
		</form>
		<tr>
		<td>첨부파일</td>
		<%  FileDao fdao = new FileDao(); 
		     List<FileInfos> flist = fdao.selectFileData(num);
		     if( flist.size() >0){
		%>
		 <td colspan="4">
		      <a href="../Download?filename=<%=flist.get(0).getSystem_file_name()%>"> <%= flist.get(0).getSystem_file_name() %> </a>
		 </td> 
		 <%}else{ %>
		 <td colspan="4">
		      파일이 없습니다!
		 </td> 
		 <%} %>
		</tr>
		<tr>
			<td colspan="2">방문 수 :<%=list.get(0).getSeq()%></td>
			<td colspan="3">작성날짜 <%=list.get(0).getWritedate()%></td>
		</tr>
		<tr>
			<td colspan="3">
				<button id="del" type="button">삭제</button>
				<button id="upd" type="button">수정</button>
				<button id="back" type="button">뒤로</button>
			</td>
		</tr>
	</table>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		 
			document.getElementById("del").onclick = function(){
			
		       var del = confirm("삭제하시겠습니까?") ;
		       if(del == true){
		    	  location.href="delete.jsp?list.get(0).getSeq()=<%=list.get(0).getSeq()%>";
		       } else {
		    	  alert("취소하였습니다");
		       }
		    }
		    document.getElementById("back").onclick = function(){
		       location.href="../BorderList.jsp";
		    }
		    document.getElementById("upd").onclick = function(){
			   location.href="update.jsp?list.get(0).getSeq()=<%=list.get(0).getSeq()%>";
		}
		document.getElementById("reply").onclick = function() {
			document.getElementById("re").submit();
		}
	</script>
	<%
		} else {
	%>
	<table border="1">
		<tr>
			<th colspan="5" width="400"><%=list.get(0).getTitle()%></th>
		</tr>
		<tr>
			<td colspan="2"><%=list.get(0).getIp()%></td>
			<td colspan="2"><%=list.get(0).getWriter()%></td>
			<td colspan="1"><%=list.get(0).getViewcount()%></td>
		</tr>
		<tr height="400">
			<td colspan="5"><%=list.get(0).getContents()%></td>
		</tr>



		<%
			ReplyDAO rdao = new ReplyDAO();
				List<ReplyInfo> listre = rdao.showReply(num);

				for (int i = 0; i < listre.size(); i++) {
					if (!(isid.equals(listre.get(i).getWriter()))) {
		%>
		<tr>
			<td><%=listre.get(i).getWriter()%></td>
			<td colspan="2"><%=listre.get(i).getComment_text()%></td>
			<td><%=listre.get(i).getIp()%></td>
			<td>작성날짜 <%=listre.get(i).getWriterdate()%></td>
		</tr>
		<%
			} else {
		%>
		<tr>
			<td><%=listre.get(i).getWriter()%></td>
			<td colspan="2"><%=listre.get(i).getComment_text()%></td>
			<td><button id="redel">삭제</button> <button id="remod">수정</button></td>
			<td>작성날짜 <%=listre.get(i).getWriterdate()%></td>
		</tr>
		
		 <script>
            document.getElementById("redel").onclick = function(){
            	 var del = confirm("삭제하시겠습니까?")
            	  if(del == true){
            		  location.href="deleteReply.jsp?lister.get=<%=listre.get(i).getComment_seq()%>&one=<%=num%>";
            	  } else {
    		    	  alert("취소하였습니다");
   		       }
		      
		    }
            document.getElementById("remod").onclick = function(){
            	location.href="replyModify.jsp?lister.get=<%=listre.get(i).getComment_seq()%>&one=<%=num%>";
 		    }
          </script>
		<%
			}
		%>
		<%
			}
		%>

		<form
			action="reply.jsp?list.get(0).getSeq()=<%=list.get(0).getSeq()%>"
			method="post" id="re2">
		<tr>
			<td colspan="3"><input type="text" id="replytext"
				name="comment_text"></td>
			<td colspan="2" align="center"><button id="reply" type="button">댓글쓰기</button></td>
		</tr>
		</form>
		<tr><td>첨부파일</td>
		<%  FileDao fdao = new FileDao(); 
		    List<FileInfos> flist = fdao.selectFileData(num);
		    if(flist.size() >0){
		%>
		<td colspan="4">
		      <a href="../Download?filename=<%=flist.get(0).getSystem_file_name()%>"> <%=flist.get(0).getSystem_file_name() %> </a>
		 </td>
		 <%}else{ %>
		 <td colspan="4">
		      파일이 없습니다!
		 </td>
		 <%} %>
		</tr>

		<tr>
			<td colspan="2">글번호 : <%=list.get(0).getSeq()%></td>
			<td colspan="3">작성날짜 <%=list.get(0).getWritedate()%></td>
		</tr>
		<tr>
			<td colspan="3">
				<button id="back" type="button">뒤로</button>
			</td>
		</tr>
	</table>
	<script>
		document.getElementById("back").onclick = function() {
			location.href = "../BorderList.jsp";
		}
		document.getElementById("reply").onclick = function() {
			location.href = "";
		}
		document.getElementById("reply").onclick = function() {
			document.getElementById("re2").submit();
		}
	</script>
	<%} %>
</body>
</html>