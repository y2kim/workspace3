package dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import infos.BookInfos;


public class BookDBO {
	
	private Connection dbConnet() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		Connection cons = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		return cons;
	}
	
	public List<BookInfos> printBookList() throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select Book_No,Book_Name,Book_Writer,"
				+ "Book_Price,publisher,genre  from book ";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		List<BookInfos> list = new ArrayList<>();

		while(rs.next()) {
			BookInfos bme = new BookInfos();
			int col1 = rs.getInt(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			int col4 = rs.getInt(4);
			String col5 = rs.getString(5);
			String col6 = rs.getString(6);
			
			bme.setBNo(col1);
			bme.setBName(col2);
			bme.setBWriter(col3);
			bme.setBPrice(col4);
			bme.setPublisher(col5);
			bme.setGenre(col6);
			
			list.add(bme);
		}
		return list;
	}
	
	public List<BookInfos> printBookListCode(String code) throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select Book_No,Book_Name,Book_Writer,"
				+ "Book_Price,publisher,genre  from book  where Book_No = ?";
		pst = con.prepareStatement(sql);
		pst.setString(1,code);
		ResultSet rs  = pst.executeQuery();
		List<BookInfos> list = new ArrayList<>();

		while(rs.next()) {
			BookInfos bme = new BookInfos();
			int col1 = rs.getInt(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			int col4 = rs.getInt(4);
			String col5 = rs.getString(5);
			String col6 = rs.getString(6);
			
			bme.setBNo(col1);
			bme.setBName(col2);
			bme.setBWriter(col3);
			bme.setBPrice(col4);
			bme.setPublisher(col5);
			bme.setGenre(col6);
			
			list.add(bme);
		}
		return list;
	}
	
	public int insertBook(BookInfos bio) throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "INSERT INTO book VALUES (?,?,?,?,?,?)";
		pst = con.prepareStatement(sql);
		pst.setInt(1,bio.getBNo());
		pst.setString(2,bio.getBName());
		pst.setString(3,bio.getBWriter());
		pst.setInt(4,bio.getBPrice());
		pst.setString(5,bio.getPublisher());
		pst.setString(6,bio.getGenre());
		int result = pst.executeUpdate();
		con.commit();
		pst.close();
		con.close();
		return result;
	}
	
	public int deleteBook(int bno) throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "Delete from book where Book_No = ? ";
		pst = con.prepareStatement(sql);
		pst.setInt(1,bno);
		int result = pst.executeUpdate();
		con.commit();
		pst.close();
		con.close();
		return result;
	}
	
	
}
