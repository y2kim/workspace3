package kh.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAO;


@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath =request.getContextPath();
		String command= requestURI.substring(contextPath.length());

		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();

		if(command.equals("/ajax01.do")) {
			String value = request.getParameter("val");
			out.println("클라이언트가 AJAX로 보낸 값 :" + value);
		}else if(command.equals("/ajax02.do")) {

			out.println("공지사항 입니다");
		}else if(command.equals("/ajax03.do")) {
			out.println("999999공지사항0123456789");
		}else if(command.equals("/signup.do")) {
			try {
				String value = request.getParameter("id");
				System.out.println(value);
				DAO data = new DAO();
				Boolean okid = data.chkIdMem(value);
				System.out.println(okid);
				if(okid) {
					out.print("ok");
				}else {
					out.print("no");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
