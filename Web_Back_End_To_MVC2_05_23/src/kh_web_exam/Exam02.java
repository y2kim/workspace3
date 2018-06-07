package kh_web_exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbo.MessageInfo;
import dbo.MsgDao;

@WebServlet("/Exam02")
public class Exam02 extends HttpServlet {

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		String msg = request.getParameter("msg");
		MsgDao mdao = new MsgDao();
		MessageInfo mif = new MessageInfo();
		mif.setName(name);
		mif.setMessage(msg);
		int result = mdao.insertMessage(mif);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
