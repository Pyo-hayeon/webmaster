package testdb;

import java.sql.Date;
import java.lang.Object;

public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
	
	public Board() {}
	
	public Board(int bno, String btitle, String bcontent, String bwriter, Date bdate) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bdate = bdate;		
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBdate() {
		return bdate;
	}
	// DBTE는 import java.sql.Date; 을 임포트 해야함
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	@Override
	public String toString() {
		return "제목:"+btitle+"\t\t내용:"+bcontent+"\t\t글쓴이:"+bwriter+"\t글쓴날:"+bdate;
	}
}
