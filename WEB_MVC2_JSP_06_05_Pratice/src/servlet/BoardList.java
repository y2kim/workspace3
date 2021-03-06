package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dao.ReplyDAO;
import dto.BoardDTO;
import dto.ReplyDTO;

@WebServlet("/BoardList")
public class BoardList extends HttpServlet {

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
			 int totalBoard = bdao.allBoard();
			 int pageSize = 3;
             int max = pageSize * currentpage;
             int min = max - pageSize ;
   
             List<BoardDTO> list = bdao.listBordercut(max, min);
             String paging =  bdao.getPageNavi(currentpage);
            request.setAttribute("page", currentpage);
     		request.setAttribute("list", list);
     		request.setAttribute("paging", paging);	
    		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
    		rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
