package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET : 수정화면 // POST : 수정처리
		req.setCharacterEncoding("utf-8");
		
		String bno = req.getParameter("bno"); //겟 또는 포스트로 값을 받아옴 (폼에 값을 히든으로 박아놔야함 :수정항목이아니라서)
		
		//페이지 값 받기
		String page = req.getParameter("page");
		
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) {
			//GET방식 (수정화면)
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			
			req.setAttribute("boardvo", board);
			req.setAttribute("page", page);
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);	
			
		}else if(req.getMethod().equals("POST")) {
			//POST방식 (수정처리)
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			
			if(svc.modifyBoard(board)) {
				//정상 등록 - 목록으로 이동
				resp.sendRedirect("boardlist.do?page="+page);
			}else {
				//등록 실패 
				board = svc.searchBoard(Integer.parseInt(bno));
				req.setAttribute("boardvo", board);
				req.setAttribute("msg", "수정할 게시글이 없습니다.");
				req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
			}
			
		}

	}

}
