package kh.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Download")
public class Download extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String filename = request.getParameter("filename");
	    String realPath = request.getServletContext().getRealPath("files");
	    String fullPath = realPath + "/"+ filename;
	    
	    response.reset();
	    response.setContentType("application/octet-stream");
	    //out.write(fullPath); 파일로 바뀌니 리스폰을 바꾼다;
	    String encodeFileName = new String(filename.getBytes("utf8"),"8859_1");
	    response.setHeader("Content-disposition", "attachment; filename="+encodeFileName);
	    //out.write(fullPath);----  여기 까지 헤더 영역 ;
	    
	    File targetFile = new File(fullPath);
	    byte[] fileContents = new byte[(int)targetFile.length()];
	    FileInputStream fis = new FileInputStream(fullPath);
	    fis.read(fileContents);
	    
	    ServletOutputStream sos = response.getOutputStream();
	    // 똑같은 코드가 두번 연속 스임 
	    sos.write(fileContents);
	    sos.flush();
	    sos.close();
	    fis.close();
	    
	   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
