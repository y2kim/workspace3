package dao;

public class Infodao {
	private int seq;
	private String name;
	private String email;
	
	
	
	
	public Infodao(int seq, String name, String email) {
		this.seq = seq;
		this.name = name;
		this.email = email;
	}
	public Infodao() {
		
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
