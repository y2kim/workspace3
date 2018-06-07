<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="bean.FileInfos"%>
<%@page import="bean.FileDao"%>
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
		String getip = request.getRemoteAddr();

		String realPath =	 request.getServletContext().getRealPath("/files/");
		int maxSize = 1024 * 1024 * 150;
		 String enc = "utf8";
		  MultipartRequest mr =
				  new MultipartRequest(request, realPath, maxSize , enc 
				  , new DefaultFileRenamePolicy());
		BoradDAO bdao = new BoradDAO();
		BorderInfos bifs = new BorderInfos();
		bifs.setTitle(mr.getParameter("title"));
		System.out.print(mr.getParameter("title"));
		bifs.setContents(mr.getParameter("contents"));
		bifs.setWriter(ids);
		System.out.print(mr.getParameter("contents"));
		bifs.setViewcount(0);
		bifs.setIp(getip);
		int val = bdao.callNextSeq();
		int result =  bdao.insertBorder(bifs,val);
		
		//int lastvalue = bdao.lastValue();
		
		String systemFileName = (mr.getFilesystemName("file"));
		String orifinalFileName =(mr.getOriginalFileName("file"));
		FileDao fdao = new FileDao();
		FileInfos fifs = new FileInfos();
		fifs.setArticle_no(val);
		fifs.setOrginal_file_name(orifinalFileName);
		fifs.setSystem_file_name(systemFileName);
		int result2 = -1;
		try{
		result2 = fdao.insertFileData(fifs);
		}catch(Exception E){
			result2 =-1;
		}
		%>
		<script>
		<%if(result>0 && result2>0) { %>
		 alert("성공적으로 글과 파일이 업로드가 되었습니다");
		 location.href="../BorderList.jsp";
		<%}else if(result>0 && result2<=0) {%>
		 alert("글 작성만이 완료되었습니다");
		 location.href="../BorderList.jsp";
		<%}else{%>
		 alert("글 작성이 실패 하였습니다 잠시후에 다시 시도하십시오");
		 location.href="../BorderList.jsp";
		<%}%>
		</script>
</body>
</html>