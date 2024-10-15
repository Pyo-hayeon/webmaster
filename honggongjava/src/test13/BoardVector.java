package test13;

//객체 생성을 위한 클래스
public class BoardVector {
	String subject;
	String content;
	String writer;
	
	public BoardVector(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
	public String getTiele() { return subject; }
	public String getContent() { return content; }
}
