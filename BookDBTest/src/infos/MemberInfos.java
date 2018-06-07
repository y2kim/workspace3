package infos;

import java.util.Date;

public class MemberInfos {
	private int UNo;
	private String UID;
	private String UName;
	private int UAge;
	private String addr;
	private String gender;
	private Date Enroll_Date;
	
	public MemberInfos() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUNo() {
		return UNo;
	}
	public void setUNo(int uNo) {
		UNo = uNo;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}
	public int getUAge() {
		return UAge;
	}
	public void setUAge(int uAge) {
		UAge = uAge;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getEnroll_Date() {
		return Enroll_Date;
	}
	public void setEnroll_Date(Date enroll_Date) {
		Enroll_Date = enroll_Date;
	}
	
	
	
}
