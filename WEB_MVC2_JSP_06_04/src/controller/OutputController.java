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

@WebServlet("/OutputController")
public class OutputController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Infodao idao = new Infodao();
		DAO dao = new DAO();
		List<Infodao> list = dao.selectInfo();
		request.setAttribute("result", list);
		RequestDispatcher rd = request.getRequestDispatcher("outputview.jsp");
		rd.forward(request, response);
		}catch (Exception e) {
			response.sendRedirect("error.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
