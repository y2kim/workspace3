package infos;

public class BookInfos {
	private int BNo;
	private String BName;
	private String BWriter;
	private int BPrice;
	private String publisher;
	private String genre;
	
	public BookInfos() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBNo() {
		return BNo;
	}
	public void setBNo(int bNo) {
		BNo = bNo;
	}
	public String getBName() {
		return BName;
	}
	public void setBName(String bName) {
		BName = bName;
	}
	public String getBWriter() {
		return BWriter;
	}
	public void setBWriter(String bWriter) {
		BWriter = bWriter;
	}
	public int getBPrice() {
		return BPrice;
	}
	public void setBPrice(int bPrice) {
		BPrice = bPrice;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	} 
	
	
}
