<%@page import="java.util.Enumeration"%>
<%@page import="bean.FileInfos"%>
<%@page import="bean.FileDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		  String realPath =	 request.getServletContext().getRealPath("/files/");  //환경정보 /진짜 경로
		  
		 //File f = new file();
		  
		  int maxSize = 1024 * 1024 * 100;
		  String enc = "utf8";
		  //System.out.print(realPath);
		  MultipartRequest mr =
				  new MultipartRequest(request, realPath, maxSize , enc 
				  , new DefaultFileRenamePolicy()); // 비추천 
		 Enumeration<String> names = mr.getFileNames();
		 FileDao dao = new FileDao();
		 while(names.hasMoreElements()){
			 String paramName = names.nextElement();
			 String orginalName = mr.getOriginalFileName(paramName);
			 String systemName = mr.getFilesystemName(paramName);
			 
			 if(orginalName != null){
				 //dao.insertFileData(0,아티클넘버,오리진네임,시스템네임 ); // 여러개 파일 업로드 
			 }
		 }
		// String systemFileName = (mr.getFilesystemName("file"));
		 //String orifinalFileName =(mr.getOriginalFileName("file"));
		// mr.getParameter("");
		 //FileInfos fifs = new FileInfos();
		 
		// FileDao dao =new FileDao();
		 //int result = dao.insertFileData(fifs);
		%>
</body>
</html>