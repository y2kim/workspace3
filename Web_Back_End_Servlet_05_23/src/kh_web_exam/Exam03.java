package kh_web_exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 매핑 : http:// localhost : 8080/ Exam03  
//mapping 되어서  이쪽으로 옴 
@WebServlet("/Exam03")
public class Exam03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
				String DB_USER = "kh";
				String DB_PASSWORD = "kh";
				
				Connection cons;
				try {
					cons = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
					String sql = "select message_id,name,message from messages";
					PreparedStatement pst = cons.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					// --- 서버쪽에서 일어나는일        --- 여기까지 비지니스 , 모델 part 라고 부름  
					// 하단부터는 클라이언트가 보는 부분 
					response.getWriter().append("<html>");
					response.getWriter().append("<head>");
					response.getWriter().append("</head>");
					response.getWriter().append("<body>");
					response.getWriter().append("<table border=1>");
					while(rs.next()) {
						int id = rs.getInt(1);
						String names = rs.getString(2);
						String msgs = rs.getString(3);
						response.getWriter().append("<tr>");	
						response.getWriter().append("<td>" + id);
						response.getWriter().append("</td>");
						response.getWriter().append("<td>" + names);
						response.getWriter().append("</td>");
						response.getWriter().append("<td>" + msgs);
						response.getWriter().append("</td>");
						response.getWriter().append("</tr>");
					}
					response.getWriter().append("</table>");
					response.getWriter().append("<input type=\"button\" value=\"return\" onclick=\"location.href='index.html'\">");
					response.getWriter().append("</body>");
					response.getWriter().append("</html>");
					// 클라이언트가 보이는 부분은 VIEW 라고 한다 
					rs.close();
					pst.close();
					cons.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				 response.getWriter().append("DB Connect failed .");
				e.printStackTrace();
				return;
			}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
