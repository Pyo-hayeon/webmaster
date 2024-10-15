package 도서관리;

import testdb.Override;

public class Book {
	private String title;
	private String writer;
	private int price;
	private int bnum;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	
	//생성자
	public Book(String title, String writer, int price, int bnum) {
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.bnum = bnum;
	}
	
	
	@Override
	public String toString() {
		//return super.toString();
		return title + "\t" + writer + "\t" + price + "\t" + bnum;
	}

}
