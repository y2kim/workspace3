package kh_infos;

public class MemberInfo {
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String address;
	
	public MemberInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MemberInfo(String id, String pw, String name, String gender, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.address = address;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
}
