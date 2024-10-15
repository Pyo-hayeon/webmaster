package test13;

import java.util.List;

public class BoardMain {

	public static void main(String[] args) {
		
		BoardDao dao = new BoardDao();
		
		List<BoardVector> list = dao.getBoardList();
		
		for(BoardVector board : list) {
			System.out.println(board.content+" "+board.subject+" "+board.writer);
		}
	}

}
