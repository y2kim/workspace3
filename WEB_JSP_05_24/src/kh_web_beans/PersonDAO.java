package kh_web_beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
	
	private Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		
		return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	
	
	public int insertData(PersonInfo pif) throws Exception {
		String col1 = pif.getName();
		String col2 = pif.getPhone();
		String col3 = pif.getEmail();
		
		
		Connection cons = getConnection();
		String sql = "insert into person values (perseq1.nextval,?,?,?)";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, col1);
		pst.setString(2, col2);
		pst.setString(3, col3);
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public List<PersonInfos> selectData() throws Exception{
		List<PersonInfos> val = new ArrayList<>();

		Connection cons = getConnection();
		String sql = "select seq,name,phone,email from person ";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			PersonInfos infos = new PersonInfos();
			int id = rs.getInt(1);
			String names = rs.getString(2);
			String phone = rs.getString(3);
			String email = rs.getString(4);
			
			infos.setIds(id);
			infos.setName(names);
			infos.setPhone(phone);
			infos.setEmail(email);
			
			val.add(infos);
		}
		return val;
	}
	
}
