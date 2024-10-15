package test13;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	List<BoardVector> list2 = new ArrayList<BoardVector>();
	
	public List<BoardVector> getBoardList() {
		list2.add(new BoardVector("글쓴이1","제목1","내용1"));
		list2.add(new BoardVector("글쓴이2","제목2","내용2"));
		list2.add(new BoardVector("글쓴이3","제목3","내용3"));
		list2.add(new BoardVector("글쓴이4","제목4","내용4"));
		
		return list2;
	}

}
