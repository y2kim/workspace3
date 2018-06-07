package kh_infos;

import java.util.Date;

public class DeliverInfo {
	private int delibery_no;
	private int pid;
	private String pname;
	private String seller_id;
	private String buyer_id;
	private Date purchase_date;
	
	public DeliverInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getDelibery_no() {
		return delibery_no;
	}

	public void setDelibery_no(int delibery_no) {
		this.delibery_no = delibery_no;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	
	
}
