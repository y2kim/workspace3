package kh_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import kh_infos.DeliverInfo;
import kh_infos.PuacherListInfo;

public class PracticeExample implements ServicePatton {

	@Override
	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
			String DB_USER = "kh";
			String DB_PASSWORD = "kh";
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
	
	public int insertBuyInfo(PuacherListInfo pli)throws Exception {
		Connection con = this.connect();
		PreparedStatement pst =null;
		String sql =
				"insert into purchase_list values(purchase_seq.nextval,?,?,?,?,?)"; 
		pst = con.prepareStatement(sql);
		pst.setString(1,pli.getId());
		pst.setInt(2,pli.getPid());
		pst.setString(3,pli.getSeller_id());
		pst.setString(4,pli.getPname());
		pst.setInt(5,pli.getPrice());
		int result = pst.executeUpdate();
		con.commit();
		pst.close();
		con.close();
		return result;
	}
	
	public int insertDliverInfo(DeliverInfo dio) throws Exception {
		Connection con = this.connect();
		PreparedStatement pst =null;
		String sql =
				"insert into delivery values(delivery_no.nextval,?,?,?,?,sysdate)"; 
		pst = con.prepareStatement(sql);
		pst.setInt(1,dio.getPid());
		pst.setString(2,dio.getPname());
		pst.setString(3,dio.getSeller_id());
		pst.setString(4,dio.getBuyer_id());
		int result = pst.executeUpdate();
		con.commit();
		pst.close();
		con.close();
		return result;
	}
	@Override
	public boolean excute1(PuacherListInfo pli , DeliverInfo dio)throws Exception {
		boolean can = false;
		Connection con = this.connect();
		PreparedStatement pst1 =null;
		PreparedStatement pst2 =null;
		String sql1 =
				"insert into purchase_list values(purchase_seq.nextval,?,?,?,?,?)"; 
		String sql2 =
				"insert into delivery values(delivery_no.nextval,?,?,?,?,sysdate)"; 
		pst1 = con.prepareStatement(sql1);
		pst2 = con.prepareStatement(sql2);
		pst1.setString(1,pli.getId());
		pst1.setInt(2,pli.getPid());
		pst1.setString(3,pli.getSeller_id());
		pst1.setString(4,pli.getPname());
		pst1.setInt(5,pli.getPrice());
		pst2.setInt(1,dio.getPid());
		pst2.setString(2,dio.getPname());
		pst2.setString(3,dio.getSeller_id());
		pst2.setString(4,dio.getBuyer_id());
		int result1 = pst1.executeUpdate();
		int result2 = pst2.executeUpdate();
		if(result1>0 && result2>0) {
			con.commit();
			pst1.close();
			pst2.close();
			con.close();
			can=true;
		}else {
			System.out.println("실패");
			can=false;
		}
		return can;
	}

	
	

}
