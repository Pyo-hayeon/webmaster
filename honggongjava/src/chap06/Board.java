package chap06;

public class Board {
	//필드
	String title;
	String content;
	String writer;
	String date;
	int hitcount;
	
	//생성자
	Board(){}	//기본생성자는 데이터 안적어줘도 됨
	
	Board(String title, String content){
		this(title, content, "로그인한 회원아이디", "현재 컴퓨터 날짜", 0);
	}
	
	Board(String title, String content, String writer){
		this(title, content, writer, "현재 컴퓨터 날짜", 0);
	}
	
	Board(String title, String content, String writer, String date){
		this(title, content, writer, date, 0);
	}
	
	Board(String title, String content, String writer, String date, int hitcount){
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.hitcount = hitcount;
	}
	//메소드
	void call() {
		System.out.printf("타이틀=%s 제목=%s 글쓴이=%s 날짜=%s 조회수=%d\n",title,content,writer,date,hitcount);
	}
}
