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

import dto.FIleDTO;


public class FileDAO {
//	public Connection dbConnect() throws Exception {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
//		String DB_USER = "kh";
//		String DB_PASSWORD = "kh";
//		
//		return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//	}
	
	private Connection dbConnect() throws Exception {
		Context context = new InitialContext();
		DataSource ds =(DataSource)context.lookup("java:/comp/env/oracle");
		return ds.getConnection() ;
	}
	
	
	public int insertFileData(FIleDTO fifs) throws Exception {
		Connection cons = dbConnect();
		String sql = "insert into upfile values(upfileseq.nextval,?,?,?)";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1,fifs.getArticle_no());
		pst.setString(2,fifs.getOrginal_file_name());
		pst.setString(3,fifs.getSystem_file_name());
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public List<FIleDTO> selectFileData(int seq) throws Exception {
		List<FIleDTO> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select * from upfile where article_no = ? ";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1,seq);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			FIleDTO fifs = new FIleDTO();
			fifs.setSeq(rs.getInt(1));
			fifs.setArticle_no(rs.getInt(2));
			fifs.setOrginal_file_name(rs.getString(3));
			fifs.setSystem_file_name(rs.getString(4));
			
			list.add(fifs);
		}
		rs.close();
		pst.close();
		cons.close();
		return list;
	}
	
	public int updateFile(FIleDTO fifs ,int seq) throws Exception {
		Connection cons = dbConnect();
		String sql = "update upfile set original_file_name =? ,system_file_name = ? where seq = ? ";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, fifs.getOrginal_file_name());
		pst.setString(2, fifs.getSystem_file_name());
		pst.setInt(3, seq);
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public void deleteFile() {
		
	}
	
	public int deleteTotalFile(int article_no)throws Exception {
		Connection cons = dbConnect();
		String sql = "delete from upfile where article_no = ?";
		PreparedStatement pst = cons.prepareStatement(sql);
		 pst.setInt(1, article_no);
		 int result = pst.executeUpdate();
		 cons.commit();
		 pst.close();
		 cons.close();
		 return result;
	}
	
	
	public List<String> deleteTotalFileSystem(int article_no)throws Exception {
		List<String> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select system_file_name from upfile where article_no = ?";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1,article_no);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			list.add(rs.getString(1));
		}
		cons.commit();
		pst.close();
		cons.close();
		return list;
	}
}
