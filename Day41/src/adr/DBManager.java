package adr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager {  // DAO : DBAccessObject
	
	AddrInfo adif = new AddrInfo();
	
	private Connection dbConnet() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		return con;
	}
	
	public List<AddrInfo> selectDB(String name) throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select ZIPCODE, SIDO, GUGUN, DONG,NVL(RI,'  '), NVL(BUNJI,'  ') from ZIPCODE where dong like '%"+name+"%'";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		List<AddrInfo> list = new ArrayList<>();
		while(rs.next()) {
			AddrInfo adif = new AddrInfo();
			
//			String zip = rs.getString("ZIPCODE");
//			String sido = rs.getString("SIDO");
//			String gugun = rs.getString("GUGUN");
//			String dong = rs.getString("DONG");
//			String ri = rs.getString("RI");
//			String bunji = rs.getString("BUNJI");
			
			String zip = rs.getString(1);
			String sido = rs.getString(2);
			String gugun = rs.getString(3);
			String dong = rs.getString(4);
			String ri = rs.getString(5);
			String bunji = rs.getString(6);
			
			adif.setZipcode(zip);
			adif.setSido(sido);
			adif.setGugun(gugun);
			adif.setDong(dong);
			adif.setRi(ri);
			adif.setBunji(bunji);
			
			list.add(adif);
		}
		return list;
	}
}
