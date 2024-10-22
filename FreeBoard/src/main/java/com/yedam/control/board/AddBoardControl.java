package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라메터 한글 포함 되어있으면 이거 해야함
		req.setCharacterEncoding("utf-8");
		
		//저장경로
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1025 * 5;
		
		//multipart요청에 대한 처리로 변경.
		MultipartRequest mr = new MultipartRequest(//
				req //1.요청정보
				,savePath	//2.저장경로
				,maxSize	//3.파일최대크기
				,"utf-8"	//4.파일이름 인코딩 방식
				,new DefaultFileRenamePolicy()	//동일파일 있는경우 바꿔주는거(리네임정
				);
		
		//title, content, writer 3개 파라미터. 받아서 인서트 해야함 db등록 하면 게시글 목록으로 이동하도록
		// 기존방식은 바이트 방식으로 데이터를 주고 받았는데 이제 위에 멀티파트 객체로 읽어와야함 (req->mr)
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("img");	//업로드한 이름 또는 리네임된 이름 가져옴
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setImg(img);
		
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
