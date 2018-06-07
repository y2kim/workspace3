package kh_infos;

public class PuacherListInfo {
	private int purchase_no ;
	private String id ;
	private int pid ;
	private String seller_id ;
	private String pname; 
	private int price ;
	
	public PuacherListInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PuacherListInfo(String id, int pid, String seller_id, String pname, int price) {
		super();
		this.id = id;
		this.pid = pid;
		this.seller_id = seller_id;
		this.pname = pname;
		this.price = price;
	}

	public PuacherListInfo(int purchase_no, String id, int pid, String seller_id, String pname, int price) {
		super();
		this.purchase_no = purchase_no;
		this.id = id;
		this.pid = pid;
		this.seller_id = seller_id;
		this.pname = pname;
		this.price = price;
	}



	public int getPurchase_no() {
		return purchase_no;
	}
	public void setPurchase_no(int purchase_no) {
		this.purchase_no = purchase_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
