package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	//목록
	//List<BoardVO> boardList();
	//리스팅 페이지
	List<BoardVO> boardList(int page);
	//등록
	boolean registerBoard(BoardVO board);
	//삭제
	boolean removeBoard(int boardNo);
	//변경
	boolean modifyBoard(BoardVO board);
	//단건조회
	BoardVO searchBoard(int boardNo);
}
