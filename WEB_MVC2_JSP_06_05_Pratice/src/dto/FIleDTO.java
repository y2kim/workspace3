package dto;

public class FIleDTO {
	
	private int seq;
	private int article_no;
	private String orginal_file_name;
	private String system_file_name;
	
	public FIleDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public String getOrginal_file_name() {
		return orginal_file_name;
	}
	public void setOrginal_file_name(String orginal_file_name) {
		this.orginal_file_name = orginal_file_name;
	}
	public String getSystem_file_name() {
		return system_file_name;
	}
	public void setSystem_file_name(String system_file_name) {
		this.system_file_name = system_file_name;
	}
}
