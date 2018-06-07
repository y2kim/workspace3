package dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import infos.BookInfos;
import infos.MemberInfos;

public class MemberDBO {
	
	private Connection dbConnet() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		Connection cons = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		return cons;
	}
	
	public List<MemberInfos> printMemberList() throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select user_No,User_Id,user_Name,"
				+ "user_Age,Addr,Gender,Enroll_Date  from customer ";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		List<MemberInfos> list = new ArrayList<>();

		while(rs.next()) {
			MemberInfos mif = new MemberInfos();
			int col1 = rs.getInt(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			int col4 = rs.getInt(4);
			String col5 = rs.getString(5);
			String col6 = rs.getString(6);
			Date col7 = rs.getDate(7);
			
			mif.setUNo(col1);
			mif.setUID(col2);
			mif.setUName(col3);
			mif.setUAge(col4);
			mif.setAddr(col5);
			mif.setGender(col6);
			mif.setEnroll_Date(col7);
			
			list.add(mif);
		}
		return list;
	}
	
	public List<MemberInfos> printNameMemberList(String name) throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select user_No,User_Id,user_Name,"
				+ "user_Age,Addr,Gender,Enroll_Date  from customer where user_Name like ? ";
		pst = con.prepareStatement(sql);
		pst.setString(1,"%"+name +"%");
		ResultSet rs  = pst.executeQuery();
		List<MemberInfos> list = new ArrayList<>();
		while(rs.next()) {
			MemberInfos mif = new MemberInfos();
			int col1 = rs.getInt(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			int col4 = rs.getInt(4);
			String col5 = rs.getString(5);
			String col6 = rs.getString(6);
			Date col7 = rs.getDate(7);
			
			mif.setUNo(col1);
			mif.setUID(col2);
			mif.setUName(col3);
			mif.setUAge(col4);
			mif.setAddr(col5);
			mif.setGender(col6);
			mif.setEnroll_Date(col7);
			
			list.add(mif);
		}
		return list;
	}
	
	
	public List<MemberInfos> printIdMemberList(String id) throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select user_No,User_Id,user_Name,"
				+ "user_Age,Addr,Gender,Enroll_Date  from customer where User_Id = ? ";
		pst = con.prepareStatement(sql);
		pst.setString(1,id);
		ResultSet rs  = pst.executeQuery();
		List<MemberInfos> list = new ArrayList<>();
		while(rs.next()) {
			MemberInfos mif = new MemberInfos();
			int col1 = rs.getInt(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			int col4 = rs.getInt(4);
			String col5 = rs.getString(5);
			String col6 = rs.getString(6);
			Date col7 = rs.getDate(7);
			
			mif.setUNo(col1);
			mif.setUID(col2);
			mif.setUName(col3);
			mif.setUAge(col4);
			mif.setAddr(col5);
			mif.setGender(col6);
			mif.setEnroll_Date(col7);
			
			list.add(mif);
		}
		return list;
	}
}
