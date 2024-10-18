package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//글 목록 보여주기. 조회 후 jsp 전달.
		//http://localhost/FreeBoard/boardlist.do?page=1
		String page = req.getParameter("page");
		//searchCondition=T&keyword=JSP
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		//3개의 값을 담기위한 클래스를 만들꺼임 => SearchDTO class
		
		page = page == null ? "1" : page;
		
		//검색조건 객채만들기
		SearchDTO search = new SearchDTO();
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		search.setPage(Integer.parseInt(page));
		
		//보드서비스 사용 객체 생성
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);
		
		//토탈 카운터
		int totalCnt = svc.getTotalCount(search);
		
		req.setAttribute("boardList", list);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", new PageDTO(Integer.parseInt(page), totalCnt));
		
		//jsp페이지
		req.getRequestDispatcher("WEB-INF/jsp/boardlist.jsp").forward(req, resp);
		
	}

}
