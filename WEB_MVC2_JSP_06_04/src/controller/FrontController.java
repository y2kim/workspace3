package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.Infodao;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	try {
		String requestURI = request.getRequestURI();
		String contextPath =request.getContextPath();
		
		System.out.println("requestURI :" + requestURI);
		System.out.println("ContextPath :" + contextPath);
		
		String command= requestURI.substring(contextPath.length());
		System.out.println("command " + command);
		Infodao dao = new Infodao();
		boolean isRedirect =true;
		String dst = null;
		DAO date = new DAO();
		if(command.equals("/output.do")) {
			List<Infodao> result = date.selectInfo();
			request.setAttribute("result", result);
			isRedirect = false;
			dst = "outputview.jsp";
		}else if(command.equals("/input.do")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			int result = date.insertInfo(name, email);
			request.setAttribute("result", result);
			isRedirect = false;
			dst = "inforview.jsp";
		}
		
		if(isRedirect) {
			response.sendRedirect(dst);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(dst);
			rd.forward(request, response);
		}
		
	 	}catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
