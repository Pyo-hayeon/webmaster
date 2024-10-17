package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라메터 한글 포함 되어있으면 이거 해야함
		req.setCharacterEncoding("utf-8");
		//title, content, writer 3개 파라미터. 받아서 인서트 해야함 db등록 하면 게시글 목록으로 이동하도록
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		BoardService svc = new BoardServiceImpl();
		try {
			//정상등록 - 글목록 이동
			svc.registerBoard(board);
			resp.sendRedirect("boardlist.do");
		} catch (Exception e) {
			//e.printStackTrace();
			//비정상등록 - 다시 글등록하는곳으로 이동
			req.setAttribute("msg", "등록하는중 오류가 발생했습니다");
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
		}
	}

}
