package bean;

import java.util.Date;

public class ReplyInfo {
	private int article_no;
	private int comment_seq;
	private String comment_text;
	private String writer;
	private Date writerdate;
	private String ip;
	
	
	public ReplyInfo() {
		
	}
	
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public int getComment_seq() {
		return comment_seq;
	}
	public void setComment_seq(int comment_seq) {
		this.comment_seq = comment_seq;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriterdate() {
		return writerdate;
	}
	public void setWriterdate(Date writerdate) {
		this.writerdate = writerdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
}
