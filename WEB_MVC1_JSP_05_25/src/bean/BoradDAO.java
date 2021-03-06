package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoradDAO {
	
	public Connection dbConnect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		
		return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	public int insertBorder(BorderInfos bifs , int val) throws Exception {
		Connection cons = dbConnect();
		String sql = "insert into board values(?,?,?,?,sysdate,?,?)";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1,val);
		pst.setString(2,bifs.getTitle());
		pst.setString(3,bifs.getContents());
		pst.setString(4,bifs.getWriter());
		pst.setInt(5,bifs.getViewcount());
		pst.setString(6,bifs.getIp());
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public List<BorderInfos> listBorder() throws Exception{
		List<BorderInfos> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select * from board ORDER BY seq desc";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			BorderInfos bifs = new BorderInfos();
			bifs.setSeq(rs.getInt(1));
			bifs.setTitle(rs.getString(2));
			bifs.setContents(rs.getString(3));
			bifs.setWriter(rs.getString(4));
			bifs.setWritedate(rs.getDate(5));
			bifs.setViewcount(rs.getInt(6));
			bifs.setIp(rs.getString(7));
			
			list.add(bifs);
		}
		rs.close();
		pst.close();
		cons.close();
		return list;
	}
	
	
	public List<BorderInfos> showGetPage(int seq) throws Exception{
		List<BorderInfos> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select * from board where seq = ?";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1,seq);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			BorderInfos bifs = new BorderInfos();
			bifs.setSeq(rs.getInt(1));
			bifs.setTitle(rs.getString(2));
			bifs.setContents(rs.getString(3));
			bifs.setWriter(rs.getString(4));
			bifs.setWritedate(rs.getDate(5));
			bifs.setViewcount(rs.getInt(6));
			bifs.setIp(rs.getString(7));
			list.add(bifs);
		}
		rs.close();
		pst.close();
		cons.close();
		return list;
	}

	public int updateVisite(int seq) throws Exception {
		Connection cons = dbConnect();
		String sql = "update board set viewcount = viewcount+1  where seq = ?";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1, seq);
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public int deleteList(int seq) throws Exception{
		Connection cons = dbConnect();
		String sql = "delete from board where seq = ?";
		PreparedStatement pst = cons.prepareStatement(sql);
		System.out.println("abc");
		pst.setInt(1, seq);
		int result = pst.executeUpdate();
		System.out.println("123");
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public int updateBorde(BorderInfos bifs, int seq) throws Exception {
		Connection cons = dbConnect();
		String sql = "update board set title = ?, contents = ? , writedate = sysdate, ip = ?  where seq = ?";
		//update members set ISBLOCKED='y' where id = 'abcd';
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, bifs.getTitle());
		pst.setString(2, bifs.getContents());
		pst.setString(3, bifs.getIp());
		pst.setInt(4, seq);
		int result = pst.executeUpdate();
		cons.commit();
		pst.close();
		cons.close();
		return result;
	}
	
	public String ischk(int seq) throws Exception {
		Connection cons = dbConnect();
		String sql = "select writer from board where seq = ?";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1,seq);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			String str = rs.getString(1);
			rs.close();
			pst.close();
			cons.close();
			return str;
		}else {
			rs.close();
			pst.close();
			cons.close();
			return null;
		}

	}
	
	
	public int allBoard() throws Exception{
		Connection cons = dbConnect();
		String sql = "select count(*) from board";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			int result = rs.getInt(1);
			rs.close();
			pst.close();
			cons.close();
			return result;
		}else {
			rs.close();
			pst.close();
			cons.close();
			return 0;
		}
	}
	
	public String getPageNavi(int now) throws Exception {
		Connection cons = dbConnect();
		String sql = "select count(*) totalCount from board";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs.next();
		rs.getInt("totalCount");
		
		int recordTotalCount =  rs.getInt("totalCount"); //전체 글의 개수를 저장하는 변수 
		int recordCountPerPage = 3; // 한 페이지에 게시글이 몇개 보일건지
		int naviCountPerPage = 3; //  한 페이지에서 내비게이터가 몇개씩 보일건지
		int pageTotalCount =0; // 전체가 몇페이지로 구성 될것인지 
		  
		if(recordTotalCount%recordCountPerPage >0) { //0 10d으로 나누어 떨어지지 않음 
			pageTotalCount = recordTotalCount / recordCountPerPage +1 ;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		//--------------------------------------
		int currentpage = now ; // 임의의 페이지 
		if(currentpage < 1) {
			currentpage = 1;
		}else if(currentpage > pageTotalCount) {
			currentpage = pageTotalCount;
		}/// 현재 페이지가 비정상인지 검증하는 코드 
		
		int startNavi = (currentpage-1) / naviCountPerPage * naviCountPerPage +1; /// 네비게이터가 시작하는 값    1- 10  11-20 21-30
		int endNavi = startNavi + naviCountPerPage -1 ; // 네비게이터 끝값 
		
		if(endNavi > pageTotalCount) { // 검증코드
			endNavi = pageTotalCount;
		}
		System.out.println("현재페이지 :" + currentpage);
		System.out.println("네비게이터 시작 :" + startNavi);
		System.out.println("네비게이터 끝 : " + endNavi);
		System.out.println(" 페이지 토탈카운트" + pageTotalCount);
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount ) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder(); /// ""   스트링풀  절약
		if(needPrev) {
			if(currentpage+naviCountPerPage>1) {
				sb.append("<a href=\"BorderList.jsp?currentPage="+(currentpage-naviCountPerPage)+"\">");
				sb.append("< ");
				sb.append("</a>");
			}else {
				sb.append("<a href=\"BorderList.jsp?currentPage="+(1)+"\">");
				sb.append("< ");
				sb.append("</a>");
			}
			
		}
		for(int i = startNavi;i<=endNavi;i++) {
			sb.append("<a href=\"BorderList.jsp?currentPage="+i+"\">");
			sb.append(i + " ");
			sb.append("</a>");
		}
		if(needNext) {
			if(currentpage+naviCountPerPage<=pageTotalCount) {
			sb.append("<a href=\"BorderList.jsp?currentPage="+(currentpage+naviCountPerPage)+"\">");
			sb.append(">");
			sb.append("</a>");
			}else {
				sb.append("<a href=\"BorderList.jsp?currentPage="+(pageTotalCount)+"\">");
				sb.append(">");
				sb.append("</a>");
			}
		}
		pst.close();
		rs.close();
		return sb.toString();
	}
	
	public String getSearchPageNavi(int now , String title ) throws Exception {
		Connection cons = dbConnect();
		String sql = "select count(*) totalCount from board where title like ? ";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, "%"+title+"%");
		ResultSet rs = pst.executeQuery();
		rs.next();
		rs.getInt("totalCount");
		String searchCode = title;
		int recordTotalCount =  rs.getInt("totalCount"); //전체 글의 개수를 저장하는 변수 
		int recordCountPerPage = 5; // 한 페이지에 게시글이 몇개 보일건지
		int naviCountPerPage = 5; //  한 페이지에서 내비게이터가 몇개씩 보일건지
		int pageTotalCount =0; // 전체가 몇페이지로 구성 될것인지 
		  
		if(recordTotalCount%recordCountPerPage >0) { //0 10d으로 나누어 떨어지지 않음 
			pageTotalCount = recordTotalCount / recordCountPerPage +1 ;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		//--------------------------------------
		int currentpage = now ; // 임의의 페이지 
		if(currentpage < 1) {
			currentpage = 1;
		}else if(currentpage > pageTotalCount) {
			currentpage = pageTotalCount;
		}/// 현재 페이지가 비정상인지 검증하는 코드 
		
		int startNavi = (currentpage-1) / naviCountPerPage * naviCountPerPage +1; /// 네비게이터가 시작하는 값    1- 10  11-20 21-30
		int endNavi = startNavi + naviCountPerPage -1 ; // 네비게이터 끝값 
		
		if(endNavi > pageTotalCount) { // 검증코드
			endNavi = pageTotalCount;
		}
		System.out.println("현재페이지 :" + currentpage);
		System.out.println("네비게이터 시작 :" + startNavi);
		System.out.println("네비게이터 끝 : " + endNavi);
		System.out.println(" 페이지 토탈카운트" + pageTotalCount);
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount ) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder(); /// ""   스트링풀  절약
		if(needPrev) {
			if(currentpage+naviCountPerPage>1) {
				sb.append("<a href=\"BoardSearhList.jsp?text="+searchCode+"&pages="+(currentpage-naviCountPerPage)+"\">");
				sb.append("< ");
				sb.append("</a>");
			}else {
				sb.append("<a href=\"BoardSearhList.jsp?text="+searchCode+"&pages="+(1)+"\">");
				sb.append("< ");
				sb.append("</a>");
			}
			
		}
		for(int i = startNavi;i<=endNavi;i++) {
			sb.append("<a href=\"BoardSearhList.jsp?text="+searchCode+"&pages="+i+"\">");
			sb.append(i + " ");
			sb.append("</a>");
		}
		if(needNext) {
			if(currentpage+naviCountPerPage<=pageTotalCount) {
			sb.append("<a href=\"BoardSearhList.jsp?text="+searchCode+"&pages="+(currentpage+naviCountPerPage)+"\">");
			sb.append(">");
			sb.append("</a>");
			}else {
				sb.append("<a href=\"BoardSearhList.jsp?text="+searchCode+"&pages="+(pageTotalCount)+"\">");
				sb.append(">");
				sb.append("</a>");
			}
		}
		pst.close();
		rs.close();
		return sb.toString();
	}
	
	public void makeDummyDate() throws Exception { /// 좀있다 가져올것 
		Connection cons = dbConnect();
		String sql = "insert into board values ()";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
	}
	
	
    public int lastValue() throws Exception {
    	Connection cons = dbConnect();
    	String sql = "select * from (select seq from board ORDER BY seq desc) where rownum <=1";
    	//여러 사람이 동시에 쿼리 날리는 경우 위험 
    	PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			int result = rs.getInt(1);
			rs.close();
			pst.close();
			cons.close();			
			return result;
		}else {
			return 0;
		}
    }
	
	public int callNextSeq() throws Exception {
		Connection cons = dbConnect();
		String sql = "select bodka.nextval from dual";
		PreparedStatement pst = cons.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			int result = rs.getInt(1);
			rs.close();
			pst.close();
			cons.close();			
			return result;
		}else {
			return 0;
		}
	}
	
	public List<BorderInfos> searchboard(String title , int large, int small) throws Exception {
		List<BorderInfos> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select * from board b where title like ? order by seq desc";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, "%"+title+"%");
		pst.setInt(2,large);
		pst.setInt(3,small);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			BorderInfos bifs = new BorderInfos();
			bifs.setSeq(rs.getInt(1));
			bifs.setTitle(rs.getString(2));
			bifs.setContents(rs.getString(3));
			bifs.setWriter(rs.getString(4));
			bifs.setWritedate(rs.getDate(5));
			bifs.setViewcount(rs.getInt(6));
			bifs.setIp(rs.getString(7));
			list.add(bifs);
		}
		rs.close();
		pst.close();
		cons.close();
		return list;
		
	}
	
	public List<BorderInfos> searchBoardCut(String title , int large, int small) throws Exception {
		List<BorderInfos> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select * from(select b.*, rownum as rnum from(select * from board b where title like ? order by seq desc)b where rownum <= ? ) where rnum >?";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setString(1, "%"+title+"%");
		pst.setInt(2,large);
		pst.setInt(3,small);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			BorderInfos bifs = new BorderInfos();
			bifs.setSeq(rs.getInt(1));
			bifs.setTitle(rs.getString(2));
			bifs.setContents(rs.getString(3));
			bifs.setWriter(rs.getString(4));
			bifs.setWritedate(rs.getDate(5));
			bifs.setViewcount(rs.getInt(6));
			bifs.setIp(rs.getString(7));
			list.add(bifs);
		}
		rs.close();
		pst.close();
		cons.close();
		return list;
		
	}
	
	
	public List<BorderInfos> listBordercut(int large, int small) throws Exception{
		List<BorderInfos> list = new ArrayList<>();
		Connection cons = dbConnect();
		String sql = "select * from (select b.*, rownum as rnum from ( select * from board b order by seq desc)b where rownum <=?)where  rnum >?";
		PreparedStatement pst = cons.prepareStatement(sql);
		pst.setInt(1,large);
		pst.setInt(2,small);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			BorderInfos bifs = new BorderInfos();
			bifs.setSeq(rs.getInt(1));
			bifs.setTitle(rs.getString(2));
			bifs.setContents(rs.getString(3));
			bifs.setWriter(rs.getString(4));
			bifs.setWritedate(rs.getDate(5));
			bifs.setViewcount(rs.getInt(6));
			bifs.setIp(rs.getString(7));
			
			list.add(bifs);
		}
		rs.close();
		pst.close();
		cons.close();
		return list;
	}
	
	
	
}
