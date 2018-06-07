<%@page import="bean.FileInfos"%>
<%@page import="bean.FileDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="bean.BorderInfos"%>
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
		   request.setCharacterEncoding("utf-8"); 
		   String ids = (String)session.getAttribute("loginId");
		   String realPath = request.getServletContext().getRealPath("/files/");
			int maxSize = 1024 * 1024 * 150;
			 String enc = "utf8";
			  MultipartRequest mr =
					  new MultipartRequest(request, realPath, maxSize , enc 
					  , new DefaultFileRenamePolicy());
		   String getip = request.getRemoteAddr();
		   int seq = Integer.parseInt((String)mr.getParameter("seq"));
		   BoradDAO bdao = new BoradDAO();
		   BorderInfos bif = new BorderInfos();
		   bif.setTitle(mr.getParameter("title"));
		   bif.setContents(mr.getParameter("contents"));
		   //bif.setWriter(ids);
		   bif.setIp(getip);
		   int result = bdao.updateBorde(bif, seq);
		   
			String systemFileName = (mr.getFilesystemName("file"));
			String orifinalFileName =(mr.getOriginalFileName("file"));
		    FileDao fdao = new FileDao();
		    FileInfos fifs = new FileInfos();
			System.out.print(orifinalFileName);
		    fifs.setArticle_no(seq);
			fifs.setOrginal_file_name(orifinalFileName);
			fifs.setSystem_file_name(systemFileName);
			System.out.print(systemFileName);
			int result2 = 0;
			try{
			result2 = fdao.updateFile(fifs, seq);
				}catch(Exception E){
			fifs.setOrginal_file_name(orifinalFileName);
			fifs.setSystem_file_name(systemFileName);
			 result2 = fdao.insertFileData(fifs);
			}
			System.out.print(result2);
		   if(result > 0 && result2 > 0) {%>
			   <script>
			   alert("수정이 완료되었습니다.");
			   location.href="list.jsp?list.get(i).getSeq()=<%=seq%>";
			   </script>
		   <%}else{%>
		     <script>
		       alert("수정에 실패하였습니다.");
		       location.href="list.jsp?list.get(i).getSeq()=<%=seq%>";
		      </script>
		   <%}%>
</body>
</html>