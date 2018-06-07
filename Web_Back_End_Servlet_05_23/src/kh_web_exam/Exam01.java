package kh_web_exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Exam01")
public class Exam01 extends HttpServlet {
	//private static final long serialVersionUID = 1L; // 직렬화 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.append("접속자 "+request.getRemoteAddr());
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String header = headerNames.nextElement();
			pw.append(header +" : "+ request.getHeader(header) + "\n"); // request 내용 확인 
		}	
		//--------------------------------------head 출력   정보
		//Runtime.getRuntime().exec("notepad"); 바디  데이터 
		// 값들을 추가   자바가 할수 있는 일  ex DB 연결 
		String msg = request.getParameter("msg");
		pw.append("클라이언트가 보낸 MSG : "+ msg + "\n");
		
		//System.out.println(request.getRemoteAddr()+"msg :" +msg);
	}

// 권고 형태 - protected 
	protected void doPost(HttpServletRequest request/*클라이언트 정보*/, HttpServletResponse response/*처리 내용*/) throws ServletException, IOException {
		doGet(request, response);
	}

}
