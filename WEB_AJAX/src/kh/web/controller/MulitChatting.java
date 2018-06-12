package kh.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.chat")
public class MulitChatting extends HttpServlet {

	
	List<String> listTalk = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath =request.getContextPath();
		String command= requestURI.substring(contextPath.length());
        String ipaddr = request.getRemoteAddr();
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		
		
		if(command.equals("/sendchatting.chat")) {
			String value = request.getParameter("talk");
			listTalk.add(value);
			System.out.println(listTalk.size());
			//System.out.println(value);
			//out.println(ipaddr+" :  " + value);
		}else if (command.equals("/chatting.chat")) {

			System.out.println(listTalk.size());
			
			for(int i=0;i<listTalk.size();i++){
			out.println(ipaddr+" : "+listTalk.get(i));
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
