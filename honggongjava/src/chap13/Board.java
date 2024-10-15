package chap13;

public class Board {
	//필드
	String subject;
	String content;
	String writer;
	int test;

	//생성자
	Board(String subject, String content, String writer){
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
	Board(String subject, String content, String writer, int test){
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.test = test;
		hashCode();
	}
	//메소드
	@Override
	public String toString() {
		return subject + " : " + content + " : " + writer;
	}

	public String getContent() {
		return content;
	}

	public String getTitle() {
		return subject;
	}

	public String getWriter() {
		return writer;
	}
}
