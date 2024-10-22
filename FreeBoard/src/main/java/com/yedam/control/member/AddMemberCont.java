package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class AddMemberCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 아이디, 이름, 폰번호, 비번은 1111
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		
		MemberService svc = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setMemberId(id);
		member.setMemberName(name);
		member.setPhone(phone);
		member.setPassword("1111");
		try {
			svc.addMember(member);
			// {"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}catch(Exception e) {
			// {"retCode":"FAIL"}
			resp.getWriter().print("{\"retCode\":\"FAIL\"}");
		}
	}

}
