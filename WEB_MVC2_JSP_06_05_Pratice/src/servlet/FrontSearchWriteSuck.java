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
import dto.BoardDTO;


@WebServlet("*.board")
public class FrontSearchWriteSuck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String requestURI = request.getRequestURI();
			String contextPath =request.getContextPath();
			
			System.out.println("requestURI :" + requestURI);
			System.out.println("ContextPath :" + contextPath);
			
			String command= requestURI.substring(contextPath.length());
			System.out.println("command " + command);
			boolean isRedirect =true;
			String dst = null;
			BoardDAO bdao = new BoardDAO();
			
			if(command.equals("/search.board")) {
				int pages = Integer.parseInt(request.getParameter("pages"));
				String searchText = (String) request.getParameter("text");
				System.out.println("pages :"+pages);
				System.out.println("searchTExt :"+searchText);
				int pageSize = 5;
		        int max = pageSize * pages;
		        int min = max - pageSize ;
				List<BoardDTO> list = bdao.searchBoardCut(searchText, max, min);
				String paging =  bdao.getSearchPageNavi(pages, searchText);
				request.setAttribute("list", list);
				request.setAttribute("paging", paging);
				isRedirect = false;
				dst = "boardSearchList.jsp";
			}else if(command.equals("/write.board")) {
				isRedirect = false;
				dst = "Board/newPage.jsp";
			}
			
			if(isRedirect) {
				System.out.println("fail");
				response.sendRedirect(dst);
			}else {
				System.out.println("sus");
				RequestDispatcher rd = request.getRequestDispatcher(dst);
				rd.forward(request, response);
			}
			
		}catch (Exception e) {
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
