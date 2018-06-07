package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int result =0 ;
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
			String sql = "insert into person values (perseq1.nextval,?,?,?)";
			PreparedStatement pst = cons.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, phone);
			pst.setString(3, email);
			result = pst.executeUpdate();
			cons.commit();
			pst.close();
			cons.close();
			pw.append("<html>");
			pw.append("<head>");
			pw.append("</head>");
			pw.append("<body>");
			pw.append("<script>");
			if(result>0) {
				pw.append("alert(\"ok\");");
			}else {
				pw.append("alert(\"fail\");");
			}
			pw.append("location.href='index.html';");
			pw.append("</script>");
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
