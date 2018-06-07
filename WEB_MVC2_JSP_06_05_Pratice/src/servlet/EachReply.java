package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDAO;
import dto.ReplyDTO;


@WebServlet("/EachReply")
public class EachReply extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int num = Integer.parseInt(request.getParameter("pagenum"));
		String isid =  (String)request.getSession().getAttribute("id");
		ReplyDAO rdao = new ReplyDAO();
		List<ReplyDTO> relist = rdao.showReply(num);
		request.setAttribute("relist", relist);
		RequestDispatcher rd = request.getRequestDispatcher("Board/listBoard.jsp");
		rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
}
