package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh_dao.CustomerDBMA;
import kh_dao.DBManager;
import kh_infos.DeliverInfo;
import kh_infos.MemberInfo;
import kh_infos.ProductInfoList;
import kh_infos.PuacherListInfo;
import kh_infos.SellerListInfo;

// 역활을 확실히 구분하기 위해 (의사소통), getConnct 중복  , 트랜잭션 
/*  1. GetConnect 중복
 *  2  개발자 사이의 소통 <-  스토리  우선 먼저 생각
 *  3  트랜잭션 관련 문제     
 *  네이티브 웹이여서그렇지만 서버를 가지면 다른방법으로 해결 가능 
 * */
public class Service { // 커밋과 클로즈는 서비스가 
	// initialization on demand holder idiom **
	// lazy initialization singleton
	private Service() {/*싱글톤*/
		
	}
	// 싱글톤 : 메모리 낭비 방지   
	//synchronized 붙이면 : Threat safe lazy init singleton
	private static Service instance = null;
	synchronized public static Service getInstance() {// public static 는 이미 메모리에 올라오고 시작되는 타이밍에 올라오지만 싱글톤 패턴은  호출할때 첫 할당됨 
		if(instance == null) {
			instance = new Service(); // synchronized 동시 에 들어오는걸 막아두기
		}
		return instance; // 한번 실행후 계속 리턴이 될것이다
	}
	
	Connection cons = null;
	
	DeliverInfo di = new DeliverInfo();
	MemberInfo mi = new MemberInfo();
	ProductInfoList pil = new ProductInfoList();
	PuacherListInfo pli = new PuacherListInfo();
	SellerListInfo sli = new SellerListInfo();
	//--
	DBManager dbm = new DBManager();//member
	CustomerDBMA cdbm = new CustomerDBMA();
	//private ~~ ~~ = new ~ ~ dbo
	
	private Connection dbConnet() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		cons = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		return cons;
	}
	
	public int insertMemberData(MemberInfo mi) throws Exception  {
		Connection con = this.dbConnet();
		int sol = 0;
		try {
			sol = dbm.insertData(mi, con);
		} catch (Exception e) {
			con.rollback();
			throw e;
		}finally {
			con.close();
		}
		return sol;
	}
	
	public boolean chkMemberData(String mi) throws Exception {
		Connection con = this.dbConnet(); 
		boolean bon = false;
		 try {
			bon = dbm.checkData(mi, con);
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			con.close();
		}
		return bon;
	}
	
	public List<SellerListInfo> printCousSeller() throws Exception {
		Connection con = this.dbConnet(); 
		List<SellerListInfo> list = new ArrayList<>();
		try {
			list = cdbm.printCoustomer(con);
		} catch (Exception e) {
			throw e; 
		}finally {
			con.close();
		}
		return list;
	}
	
	public List<ProductInfoList> productInfos() throws Exception {
		Connection con = this.dbConnet();
		List<ProductInfoList> list = new ArrayList<>();
		try {
			list = cdbm.productInfo(con);
		}catch (Exception e) {
			throw e; 
		}finally {
			con.close();
		}
		return list;
	}
	
	public String proSeaSels(String str) throws Exception {
		Connection con = this.dbConnet();
		String ans = null;
		try {
			ans = cdbm.proSeaSel(str, con);
		}catch (Exception e) {
			throw e; 
		}finally {
			con.close();
		}
		return ans;
	}
	
	public int insertBuyDliver (PuacherListInfo pli ,DeliverInfo dio) throws Exception {
		Connection con = this.dbConnet();
		try {
			int result1 = cdbm.insertBuyInfo(pli, con);
			int result2 = cdbm.insertDliverInfo(dio, con);
			con.commit();
			return result1+result2;
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			con.close();
		}
	}
	
	public boolean login(String id , String pw) throws Exception {
		Connection con = this.dbConnet(); 
		boolean bon = false;
		try {
			bon = dbm.loginCkeckData(id, pw, con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			con.close();
		}
		
		return bon;
	}
	
	public List<DeliverInfo> selectDelivers() throws Exception {
		Connection con = this.dbConnet(); 
		List<DeliverInfo> list = new ArrayList<>();
		try {
			list = cdbm.selectDeliver(con);
		}catch (Exception e) {
			throw e; 
		}finally {
			con.close();
		}
		return list;
	}
	
	public List<PuacherListInfo> selectPurcherLists() throws Exception {
		Connection con = this.dbConnet(); 
		List<PuacherListInfo> list = new ArrayList<>();
		try {
			list = cdbm.selectPurcherList(con);
		}catch (Exception e) {
			throw e; 
		}finally {
			con.close();
		}
		return list;
	}
}
