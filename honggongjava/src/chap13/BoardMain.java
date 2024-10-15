package chap13;

import java.util.List;
import java.util.Vector;

public class BoardMain {

	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1", 11));
		list.add(new Board("제목2", "내용2", "글쓴이2", 22));
		list.add(new Board("제목3", "내용3", "글쓴이3", 33));
		list.add(new Board("제목4", "내용4", "글쓴이4", 44));
		list.add(new Board("제목5", "내용5", "글쓴이5", 55));
		
		list.remove(2);
		list.remove(3);
		
		for(int i=0; i<list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer + "\t" + board.test);
		}
		
		System.out.println();
		for(Board str : list) {
			System.out.println(str.subject + "\t" + str.content + "\t" + str.writer + "\t" + str.test);
		}
		
		
		//해시코드
		Board bd = new Board("제목", "내용", "글쓴이");
		//Board 클래스에 toString 오버라이딩 되어있음
		System.out.println(bd);	// <= 객체 자체를 출력하면 toString() 메소드를 가져옴 // toString 메소드를 자체로 만들면 원하는 내용을 출력함
		System.out.println(bd.hashCode());	// 이건 진짜 객체의 인트값
		System.out.println(bd.toString());

	}

}