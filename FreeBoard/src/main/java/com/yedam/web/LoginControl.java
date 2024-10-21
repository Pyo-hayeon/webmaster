package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("LogId");
		String pw = req.getParameter("LogPw");
		
		if(req.getMethod().equals("GET")) {
			//req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);	
			req.getRequestDispatcher("WEB-INF/jsp/logForm.jsp").forward(req, resp);
			//.jsp 아니고 tiles 하면 헤더랑 푸터랑 아사이드 붙어서 그냥 통으로 한페이지만 보여줘야해서
			
		}else if(req.getMethod().equals("POST")) {
			MemberService svc = new MemberServiceImpl();
			MemberVO member = svc.loginCheck(id, pw);
			
			if(member==null) {
				//로그인 실패
				req.setAttribute("msg", "아이디와 비밀번호를 확인하세요");
				req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
				return;
			}
			
			//정상 로그인 session객체 (프로그램이 제공해줌)
			HttpSession session = req.getSession();
			session.setAttribute("logId", id);
			
			//세션 담아서 글목록으로 이동
			if(member.getResponsibility().equals("User"))
				resp.sendRedirect("boardlist.do");
			else if (member.getResponsibility().equals("Admin"))
				resp.sendRedirect("memberList.do");
		}
	}
}
