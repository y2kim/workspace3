package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DAO {
//	public Connection dbConnect() throws Exception {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
//		String DB_USER = "kh";
//		String DB_PASSWORD = "kh";
//		
//		return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//	}
//	
	
	private Connection dbConnect() throws Exception {
		Context context = new InitialContext();
		DataSource ds =(DataSource)context.lookup("java:/comp/env/oracle");
		return ds.getConnection() ;
	}
	
	
	public int insertInfo(String name, String email)throws Exception {
		Connection cons = dbConnect();
		String sql = "insert into info values(info_seq.nextval,?,?)";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1,name);
		pst.setString(2,email);
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public List<Infodao> selectInfo()throws Exception{
		Connection cons = dbConnect();
		String sql = "select * from info";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<Infodao> list = new ArrayList<>();
		while(rs.next()) {
			Infodao ifd = new Infodao();
			ifd.setSeq(rs.getInt("seq"));
			ifd.setName(rs.getString("name"));
			ifd.setEmail(rs.getString("email"));
			list.add(ifd);
		}
		rs.close();
		pst.close();
		cons.close();
		return list;
	}
	
}
