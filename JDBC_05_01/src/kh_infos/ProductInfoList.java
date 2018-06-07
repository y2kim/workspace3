package kh_infos;

public class ProductInfoList {
	private int pid;
	private String sellId;
	private String pname;
	private int price;
	
	public ProductInfoList() {
		
	}
	
	public ProductInfoList(int pid, String sellId, String pname, int price) {
		super();
		this.pid = pid;
		this.sellId = sellId;
		this.pname = pname;
		this.price = price;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getSellId() {
		return sellId;
	}
	public void setSellId(String sellId) {
		this.sellId = sellId;
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
