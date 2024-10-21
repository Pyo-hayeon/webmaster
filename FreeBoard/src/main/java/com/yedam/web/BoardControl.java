package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// board.do -> 상세조회(bon) -> 조회 -> board.jsp 출력.
		//http://localhost/FreeBoard/board.do?bno=1
		String bno = req.getParameter("bno");
		//페이지 받아오는 변수
		String page = req.getParameter("page");
		
		//검색 받아오는 변수
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.searchBoard(Integer.parseInt(bno));
		
		req.setAttribute("boardvo", board);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		//req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
		req.getRequestDispatcher("board/board.tiles").forward(req, resp);
		//req.getRequestDispatcher("board/boardlist.tiles").forward(req, resp);

	}

}
