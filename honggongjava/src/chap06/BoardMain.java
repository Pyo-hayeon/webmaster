package chap06;

public class BoardMain {
	public static void main(String[] args) {
		//Board(String title, String content, String writer, String date, int hitcount){
		Board bd1 = new Board("제목1","내용1");
		Board bd2 = new Board("제목2","내용2","글쓴이1");
		Board bd3 = new Board("제목3","내용3","글쓴이2","2024-09-24");
		Board bd4 = new Board("제목4","내용4","글쓴이3","2024-09-25",100);
		//위에꺼처럼 다 명시했으면 기본생성자도 클래스에 명시해줘야함
		Board bd5 = new Board();
		bd5.title = "제목5";
		bd5.hitcount = 999;
		
		System.out.printf("%s | %s | %s | %s | %d\n",bd1.title,bd1.content,bd1.writer,bd1.date,bd1.hitcount);
		System.out.printf("%s | %s | %s | %s | %d\n",bd2.title,bd2.content,bd2.writer,bd2.date,bd2.hitcount);
		System.out.printf("%s | %s | %s | %s | %d\n",bd3.title,bd3.content,bd3.writer,bd3.date,bd3.hitcount);
		System.out.printf("%s | %s | %s | %s | %d\n",bd4.title,bd4.content,bd4.writer,bd4.date,bd4.hitcount);
		System.out.printf("%s | %s | %s | %s | %d\n",bd5.title,bd5.content,bd5.writer,bd5.date,bd5.hitcount);
		
		System.out.println();
		bd1.call();
		bd2.call();
		bd3.call();
		bd4.call();
	}
}
