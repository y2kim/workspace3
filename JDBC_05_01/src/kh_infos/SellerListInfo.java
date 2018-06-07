package kh_infos;

public class SellerListInfo {
	private String seq;
	private String id;
	
	public SellerListInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public SellerListInfo(String id,String seq) {
		this.id = id;
		this.seq = seq;
	}
	
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
