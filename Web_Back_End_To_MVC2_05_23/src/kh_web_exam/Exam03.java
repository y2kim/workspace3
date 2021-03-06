package kh_web_exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbo.MessageInfo;
import dbo.MsgDao;

//서블릿 매핑 : http:// localhost : 8080/ Exam03  
//mapping 되어서  이쪽으로 옴 
@WebServlet("/Exam03")
public class Exam03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			MsgDao mda = new MsgDao();
			List<MessageInfo> list = mda.selectMessage();
			request.setAttribute("result", list);
			RequestDispatcher rd = request.getRequestDispatcher("table.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
