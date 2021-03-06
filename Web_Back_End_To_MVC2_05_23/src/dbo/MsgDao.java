package dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MsgDao {
	
	public Connection dbConnect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		
		return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	public List<MessageInfo> selectMessage() throws Exception {
		List<MessageInfo> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select message_id,name,message from messages";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			MessageInfo mif = new MessageInfo();
			mif.setMessage_id(rs.getInt(1));
			mif.setName(rs.getString(2));
			mif.setMessage(rs.getString(3));
			
			list.add(mif);
		}
		cons.commit();
		pst.close();
		cons.close();
		return list;
	}
	
	public int insertMessage(MessageInfo mif) throws Exception {
		Connection cons = dbConnect();
		String sql = "insert into messages values (msg_idsq.nextval,?,?)";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, mif.getName());
	    pst.setString(2, mif.getMessage());
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result; 
	}
}
