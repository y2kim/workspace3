package kh_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kh_infos.DeliverInfo;
import kh_infos.ProductInfoList;
import kh_infos.PuacherListInfo;
import kh_infos.SellerListInfo;

public class CustomerDBMA {

	private Connection dbConnet() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		return con;
	}

	public List<SellerListInfo> printCoustomer() throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select seq, id from seller ";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		List<SellerListInfo> list = new ArrayList<>();

		while(rs.next()) {
			SellerListInfo sli = new SellerListInfo();
			String seq = rs.getString("seq");
			String ids = rs.getString("id");

			sli.setId(ids);
			sli.setSeq(seq);

			list.add(sli);
		}
		return list;
	}

	public List<ProductInfoList> productInfo() throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select pid,seller_id,pname,price from PRODUCT ";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		List<ProductInfoList> list = new ArrayList<>();
		while(rs.next()) {
			ProductInfoList pil = new ProductInfoList();
			int pid = rs.getInt(1);
			String seid = rs.getString(2);
			String pname = rs.getString(3);
			int price = rs.getInt(4);
			
			pil.setPid(pid);
			pil.setSellId(seid);
			pil.setPname(pname);
			pil.setPrice(price);
			
			list.add(pil);
		}
		return list;
	}
	
	public int insertBuyInfo(PuacherListInfo pli)throws Exception {
		Connection con = this.dbConnet();
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
	
	public String proSeaSel(String selp)throws Exception {
		String ans = null;
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select id from seller where id = ? ";
		pst = con.prepareStatement(sql);
		pst.setString(1, selp);
		ResultSet rs  = pst.executeQuery();
		while(rs.next()) {
			ans=rs.getString(1);
		}
		return ans;
	}
	
	public List<PuacherListInfo> selectPurcherList() throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select purchase_no,id,pid,seller_id,pname,price from purchase_list ";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		List<PuacherListInfo> list = new ArrayList<>();
		while(rs.next()) {
			PuacherListInfo pli = new PuacherListInfo();
			int pn = rs.getInt(1);
			String ids = rs.getString(2);
			int pids = rs.getInt(3);
			String si = rs.getString(4);
			String pname = rs.getString(5);
			int price = rs.getInt(6);
			
			pli.setPurchase_no(pn);
			pli.setId(ids);
			pli.setPid(pids);
			pli.setSeller_id(si);
			pli.setPname(pname);
			pli.setPrice(price);
			
			list.add(pli);
		}
		return list;
	}
	
	public int insertDliverInfo(DeliverInfo dio) throws Exception {
		Connection con = this.dbConnet();
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
	
	public List<DeliverInfo> selectDeliver() throws Exception{
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select delibery_no,pid,pname,seller_id,buyer_id,purchase_date from delivery ";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		List<DeliverInfo> list = new ArrayList<>();
		while(rs.next()) {
			DeliverInfo dil = new DeliverInfo();
			int co1 = rs.getInt(1);
			int co2 = rs.getInt(2);
			String co3 =rs.getString(3);
			String co4 =rs.getString(4);
			String co5 =rs.getString(5);
			Date co6 = rs.getDate(6);
			
			dil.setDelibery_no(co1);
			dil.setPid(co2);
			dil.setPname(co3);
			dil.setSeller_id(co4);
			dil.setBuyer_id(co5);
			dil.setPurchase_date(co6);
			
			list.add(dil);
		}
		return list;
	}
	
}
