package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReplyDAO {
	
	public Connection dbConnect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		
		return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	public int insertBorder(ReplyInfo rifs) throws Exception {
		Connection cons = dbConnect();
		String sql = "insert into board_comment values(?,comment_seq.nextval,?,?,sysdate,?)";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1, rifs.getArticle_no());
		pst.setString(2, rifs.getComment_text());
		pst.setString(3, rifs.getWriter());
		pst.setString(4, rifs.getIp());
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public void countReply() throws Exception{
		Connection cons = dbConnect();
		String sql = "select count(*) from board_comment";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
	}
	 public List<ReplyInfo> showReply(int article_no) throws Exception{
		List<ReplyInfo> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select * from board_comment where article_no = ? order by WRITERDATE asc";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1, article_no);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			ReplyInfo rif = new ReplyInfo();
			rif.setArticle_no(rs.getInt(1));
			rif.setComment_seq(rs.getInt(2));
			rif.setComment_text(rs.getString(3));
			rif.setWriter(rs.getString(4));
			rif.setWriterdate(rs.getDate(5));
			rif.setIp(rs.getString(6));
			
			list.add(rif);
		}
		return list;
	 }
	
	 public int deleteReply(int comment_seq)throws Exception {
		 Connection cons = dbConnect();
		 String sql = "delete from board_comment where comment_seq = ?";
		 PreparedStatement pst = cons.prepareStatement(sql);
		 pst.setInt(1, comment_seq);
		 int result = pst.executeUpdate();
		 cons.commit();
		 pst.close();
		 cons.close();
		 return result;
	 }
	 
	 public int deleteTotalReply(int article_no)throws Exception {
		 Connection cons = dbConnect();
		 String sql = "delete from board_comment where article_no = ?";
		 PreparedStatement pst = cons.prepareStatement(sql);
		 pst.setInt(1, article_no);
		 int result = pst.executeUpdate();
		 cons.commit();
		 pst.close();
		 cons.close();
		 return result;
	 }
	 
	 public int modifyReply(String contents , int comment_seq)throws Exception {
		 Connection cons = dbConnect();
		 String sql = "update  board_comment set comment_text = ? , writerdate = sysdate  where comment_seq = ? ";
		 PreparedStatement pst = cons.prepareStatement(sql);
		 pst.setString(1, contents);
		 pst.setInt(2, comment_seq);
		 int result = pst.executeUpdate();
		 cons.commit();
		 pst.close();
		 cons.close();
		 return result;
	 }
	 
}
