package dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MsgDao {
	
	public Connection dbConnect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		
		return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	public void selectMessage() throws Exception {
		Connection cons = dbConnect();
		String sql = "select message_id,name,message from messages";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			
		}
	}
	
}
