package chap07_books;

public class Book {
	private String bname;
	private int bnum;
	private int bprice;


	String bookgetter() {
		return "제목:"+bname+" 번호:"+bnum+" 가격:"+bprice;
	}
	
	int pricegetter() {
		return bprice;
	}
	
	void booksetter(String bname, int bnum, int bprice) {
		this.bname = bname;
		this.bnum = bnum;
		this.bprice = bprice;
	}
	
}
