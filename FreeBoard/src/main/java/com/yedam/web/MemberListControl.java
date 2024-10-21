package com.yedam.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberListControl");
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		
		req.setAttribute("memberList", list);
		
		try {
			//jsp폴더 만들어서 거기에 파일 넣었음
			//memberList.do 요청재지정 => jsp/memberList.jsp
			//요청 재지정 (요청페이지를 다른곳으로 바꿈)
			//req.getRequestDispatcher("WEB-INF/jsp/memberList.jsp").forward(req, resp);
			req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
