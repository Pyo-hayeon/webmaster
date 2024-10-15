package test13;

import java.util.*;

//리스트 객체를 생성하여 컨트롤 하기 위한 클래스
public class BoardVectorControl {
	List<BoardVector> list = new Vector<BoardVector>();
	
	public void setBoard(String subject, String content, String writer) {
		list.add(new BoardVector(subject, content, writer));
	}

}
