package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class deleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET : 삭제화면 // POST : 삭제처리
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno"); //겟 또는 포스트로 값을 받아옴 (폼에 값을 히든으로 박아놔야함 :수정항목이아니라서)
		
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) {
			//GET방식 (삭제화면)
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			
			req.setAttribute("boardvo", board);
			req.getRequestDispatcher("WEB-INF/jsp/deleteForm.jsp").forward(req, resp);	
			
		}else if(req.getMethod().equals("POST")) {
			//POST방식 (삭제처리)
			System.out.println(bno);
			if(svc.removeBoard(Integer.parseInt(bno))) {
				//정상 삭제 - 목록으로 이동
				resp.sendRedirect("boardlist.do");
			}else {
				//삭제 실패 
				req.setAttribute("msg", "삭제 할수 없습니다.");
				req.getRequestDispatcher("WEB-INF/jsp/deleteForm.jsp").forward(req, resp);
			}
			
		}
	}
	

}
