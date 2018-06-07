package infos;

import java.util.Date;

public class LibraryInfos {
	private int leaseNo;
	private int bookNo;
	private String userId;
	private Date leaseDate;
	private Date returnDate;
	
	public LibraryInfos() {
		// TODO Auto-generated constructor stub
	}
	
	public int getLeaseNo() {
		return leaseNo;
	}
	public void setLeaseNo(int leaseNo) {
		this.leaseNo = leaseNo;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getLeaseDate() {
		return leaseDate;
	}
	public void setLeaseDate(Date leaseDate) {
		this.leaseDate = leaseDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
}
