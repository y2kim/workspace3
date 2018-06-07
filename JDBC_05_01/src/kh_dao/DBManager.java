package kh_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kh_infos.MemberInfo;

public class DBManager {
	
	
	
	public int insertData(MemberInfo info , Connection cons)throws Exception {
		Connection con = cons;
		PreparedStatement pst =null;
		String sql =
				"insert into member values(member_seq.nextval,?,?,?,?,?,SYSDATE)"; 
		pst = con.prepareStatement(sql);
		pst.setString(1,info.getId());
		pst.setString(2,info.getPw());
		pst.setString(3,info.getName());
		pst.setString(4,info.getGender());
		pst.setString(5,info.getAddress());
		int result = pst.executeUpdate();
		pst.close();
		return result;
	}
	
	public boolean checkData(String name , Connection cons)throws Exception {
		boolean ishad = false;
		Connection con = cons;
		PreparedStatement pst =null;
		String sql = "Select id From member where ID like '"+name+"'";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		if(rs.next()) {
			ishad = true;
		}else {
			ishad = false;
		}
		
		return ishad;
	}
	
	public boolean loginCkeckData(String id , String pwd , Connection cons) throws Exception {
		boolean issucc = false;
		Connection con = cons;
		 
		String sql = "Select id From member where ID like ? and PW like ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, id);
		pst.setString(2, pwd);
		ResultSet rs  = pst.executeQuery();
		if(rs.next()) {
			issucc = true;
		}else {
			issucc = false;
		}
		return issucc;
	}
	
}
