package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dao.BoardDAO;
import dao.ReplyDAO;
import dto.BoardDTO;
import dto.ReplyDTO;
import kh.web.dbutils.DBUtils;

@WebServlet("/ListBoard")
public class ListBoard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int currentpage = 0;
			try{ 
				currentpage =Integer.parseInt(request.getParameter("currentPage"));
			}catch(Exception e){
				currentpage=0; 
			}  
			if(currentpage == 0){
				currentpage =1;
			}else{
				currentpage =Integer.parseInt(request.getParameter("currentPage"));
			}   	
			
			BoardDAO bdao = new BoardDAO();
			ReplyDAO rdao = new ReplyDAO();
			 int totalBoard = bdao.allBoard();
			 int pageSize = 3;
             int max = pageSize * currentpage;
             int min = max - pageSize ;
             List<BoardDTO> lists = bdao.listBordercut(max, min); 
             request.setAttribute("page", currentpage);
             
		int num = Integer.parseInt(request.getParameter("pagenum"));
		String isid =  (String)request.getSession().getAttribute("id");
		String hadid = bdao.ischk(num);
		if(isid.equals(hadid)) {
			
		}else {
			bdao.updateVisite(num);
		}
		List<BoardDTO> list = bdao.showGetPage(num);
		String writer = list.get(0).getWriter();
		List<ReplyDTO> relist = rdao.showReply(num);
 		request.setAttribute("listBoard", list);
 		request.setAttribute("writer", writer);	
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
