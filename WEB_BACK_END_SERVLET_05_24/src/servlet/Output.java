package servlet;

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


@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			pw.append("DB Connect failed .");
			e.printStackTrace();
			return;
		}
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		try {
			Connection cons = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			String sql = "select seq,name,phone,email from person ";
			PreparedStatement pst = cons.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			pw.append("<html>");
			pw.append("<head>");
			pw.append("</head>");
			pw.append("<body>");
			pw.append("<table border=1>");
			while(rs.next()) {
				int id = rs.getInt(1);
				String names = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				pw.append("<tr>");
				pw.append("<td>"+id+"</td>");
				pw.append("<td>"+names+"</td>");
				pw.append("<td>"+phone+"</td>");
				pw.append("<td>"+email+"</td>");
				pw.append("</tr>");
			}
			pw.append("</table>");
			pw.append("</body>");
			pw.append("</html>");
		} catch (SQLException e) {
			pw.append("DB Connect failed .");
			e.printStackTrace();
			return;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
