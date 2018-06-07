package bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO  {
	
	public Connection dbConnect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		
		return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	public boolean chkIdMem(String ids) throws Exception {
		boolean doubleid = false;
		Connection cons = dbConnect();
		String sql = "select id from members where id = ? ";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, ids);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			doubleid = false;
		}else {
			doubleid = true;
		}
		return doubleid;
	}
	
	
	
	public int insertMember(MemberInfos mifs) throws Exception {
		Connection cons = dbConnect();
		String sql = "insert into members values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1,mifs.getId());
		pst.setString(2,mifs.getPw());
		pst.setString(3,mifs.getName());
		pst.setString(4,mifs.getPhone1());
		pst.setString(5,mifs.getPhone2());
		pst.setString(6,mifs.getPhone3());
		pst.setString(7,mifs.getEmail());
		pst.setString(8,mifs.getZipcode());
		pst.setString(9,mifs.getAddress1());
		pst.setString(10,mifs.getAddress2());
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public boolean chklogin(String id, String pw) throws Exception {
		boolean doubleid;
		Connection cons = dbConnect();
		String sql = "select * from members where id = ? and pw = ? ";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, id);
		pst.setString(2, pw);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			doubleid = true;
		}else {
			doubleid = false;
		}
		rs.close();
		pst.close();
		cons.close();
		return doubleid;
	}
	
	public List<MemberInfos> myinfo(String id) throws Exception {
		List<MemberInfos> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select * from members where id = ? ";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			MemberInfos mifs = new MemberInfos();
			String col1 = rs.getString(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			String col4 = rs.getString(4);
			String col5 = rs.getString(5);
			String col6 = rs.getString(6);
			String col7 = rs.getString(7);
			String col8 = rs.getString(8);
			String col9 = rs.getString(9);
			String col10 = rs.getString(10);
			mifs.setId(col1);
			mifs.setPw(col2);
			mifs.setName(col3);
			mifs.setPhone1(col4);
			mifs.setPhone2(col5);
			mifs.setPhone3(col6);
			mifs.setEmail(col7);
			mifs.setZipcode(col8);
			mifs.setAddress1(col9);
			mifs.setAddress2(col10);
			
			list.add(mifs);
		}
		rs.close();
		pst.close();
		cons.close();
		return list;
	}
	
	public List<MemberInfos> listAll() throws Exception {
		List<MemberInfos> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select * from members";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			MemberInfos mifs = new MemberInfos();
			String col1 = rs.getString(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			String col4 = rs.getString(4);
			String col5 = rs.getString(5);
			String col6 = rs.getString(6);
			String col7 = rs.getString(7);
			String col8 = rs.getString(8);
			String col9 = rs.getString(9);
			String col10 = rs.getString(10);
			String col11 = rs.getString(11);
			mifs.setId(col1);
			mifs.setPw(col2);
			mifs.setName(col3);
			mifs.setPhone1(col4);
			mifs.setPhone2(col5);
			mifs.setPhone3(col6);
			mifs.setEmail(col7);
			mifs.setZipcode(col8);
			mifs.setAddress1(col9);
			mifs.setAddress2(col10);
			mifs.setIsblocked(col11);
			list.add(mifs);
		}
		rs.close();
		pst.close();
		cons.close();
		return list;
	}
	
	
	public int deleteMember(String id) throws Exception {
		Connection cons = dbConnect();
		String sql = "delete from members where id = ? ";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1,id);
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public int updateMember(MemberInfos mifs , String ids) throws Exception{
		Connection cons = dbConnect();
		String sql = "update members set pw = ?, name =? , phone1 = ? , phone2 = ? , phone3 = ? ,"
				+ " email = ? , zipcode = ? , address1 = ? , address2 = ? where id = ? ";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1,mifs.getPw());
		pst.setString(2,mifs.getName());
		pst.setString(3,mifs.getPhone1());
		pst.setString(4,mifs.getPhone2());
		pst.setString(5,mifs.getPhone3());
		pst.setString(6,mifs.getEmail());
		pst.setString(7,mifs.getZipcode());
		pst.setString(8,mifs.getAddress1());
		pst.setString(9,mifs.getAddress2());
		pst.setString(10,ids);
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public int doblock(String id) throws Exception {
		Connection cons = dbConnect();
		String sql = "update members set ISBLOCKED='y' where id = ?";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1,id);
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public int unblock(String id) throws Exception {
		Connection cons = dbConnect();
		String sql = "update members set ISBLOCKED='n' where id = ?";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1,id);
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
}
