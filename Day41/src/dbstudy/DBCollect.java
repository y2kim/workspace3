package dbstudy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBCollect  { //Student DAO
	
	TypeStudent type = new TypeStudent();
	
	private Connection makeConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		return con;
	}

	public int insertData(TypeStudent tyo) throws Exception {
		Connection con = this.makeConnection();
		PreparedStatement pst =null;
		String sql =
				"insert into student values(student_seq.nextval,?,?)"; 
		pst = con.prepareStatement(sql);
		pst.setString(1,tyo.getName());
		pst.setInt(2,tyo.getScore());
		int result = pst.executeUpdate();
		con.commit();
		pst.close();
		con.close();
		return result;
	}
	public int deleteData(String stuid)throws Exception {
		
		PreparedStatement pst =null;
		Connection con = this.makeConnection();
		String sql =
				"delete from student where ID =?"; 
		pst = con.prepareStatement(sql);
		pst.setString(1, stuid);
		int result = pst.executeUpdate();
		con.commit();
		pst.close();
		con.close();
		return result;
	}
	public List<TypeStudent> selectData()throws Exception {
		Connection con = this.makeConnection();
		PreparedStatement pst =null;
		
		String sql = "Select id,name,score from student order by score desc ";
		String sql2 = "Select id,name,score,rank() over (order by score desc) from student order by score desc ";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		//List sel = new ArrayList<>();
		List<TypeStudent> sel = new ArrayList<>();
		while(rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			int score = rs.getInt("score");
//			int ranks = rs.getInt(4);
			TypeStudent tmp = new TypeStudent();
			tmp.setId(id);
			tmp.setName(name);
			tmp.setScore(score);
			sel.add(tmp);
//			sel.add(rs.getString(1)+" ,"+ rs.getString(2)+" ,"
//					+rs.getInt(3)+"점 "+rs.getInt(4)+"위");
			
		}
		
		return sel;
		
	}
	public List selectUplist()throws Exception {
		List sel = new ArrayList<>();
		Connection con = this.makeConnection();
		PreparedStatement pst =null;
		
		String sql = "Select id,name,score from student order by id desc ";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		while(rs.next()) {
			sel.add(rs.getString(1)+" ,"+ rs.getString(2)+" ,"
					+rs.getInt(3)+"점 ");
		}
		return sel;
		
	}
	public int updateData(String name , int score , String stuid) throws Exception {
		Connection con = this.makeConnection();
		PreparedStatement pst =null;
		
		String sql = //	"delete from student where ID =?"; 
				"update student set name = ?, score =? where id = ?"; 
		pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setInt(2, score);
		pst.setString(3, stuid);
		int result = pst.executeUpdate();
		con.commit();
		pst.close();
		con.close();
		return result;
	}
}
