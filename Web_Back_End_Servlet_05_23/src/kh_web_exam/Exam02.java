package kh_web_exam;

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

@WebServlet("/Exam02")
public class Exam02 extends HttpServlet {

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		String msg = request.getParameter("msg");
		int result =0 ;
//		pw.append("클라이언트가 보낸 name : "+ name + "\n");
//		pw.append("클라이언트가 보낸 MSG : "+ msg + "\n");
//		pw.append("접속자 "+request.getRemoteAddr()+msg+name);
//		System.out.println(request.getRemoteAddr()+"msg :" +msg);
		
		
		
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
				String DB_USER = "kh";
				String DB_PASSWORD = "kh";
				
				Connection cons;
				try {
					cons = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
					String sql = "insert into messages values (msg_idsq.nextval,?,?)";
					PreparedStatement pst = cons.prepareStatement(sql);
					pst.setString(1, name);
					pst.setString(2, msg);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				pw.append("DB Connect failed .");
				e.printStackTrace();
				return;
			}
			
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
